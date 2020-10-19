package com.fszn.framework.shiro.realm;


import com.fszn.common.exception.user.UserPasswordNotMatchException;
import com.fszn.common.json.JSON;
import com.fszn.common.json.JSONObject;
import com.fszn.common.utils.http.HttpUtils;
import com.fszn.framework.util.ShiroUtils;
import com.fszn.system.domain.SysUser;
import com.fszn.system.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName TouristRealm
 * @Description TODO   游客免密登录
 * @Author 阿江
 * @Date 2020/10/13 15:36
 * @Version 1.0
 */


public class TouristRealm extends AuthorizingRealm {
    private static final Logger log = LoggerFactory.getLogger(TouristRealm.class);

    @Autowired
    ISysUserService iSysUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = ShiroUtils.getSysUser();
        // 角色列表
        Set<String> roles = new HashSet<String>();
        // 功能列表
        Set<String> menus = new HashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 管理员拥有所有权限
        if (user.isAdmin()) {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        } else {
//            roles = roleService.selectRoleKeys(user.getUserId());
//            menus = menuService.selectPermsByUserId(user.getUserId());
//            // 角色加入AuthorizationInfo认证对象
//            info.setRoles(roles);
//            // 权限加入AuthorizationInfo认证对象
//            info.setStringPermissions(menus);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String password = "";
        SysUser sysUser = null;
        String token = upToken.getUsername();
        try {
            String result = HttpUtils.sendGet("https://sso.ahzwfw.gov.cn/uccp-service/user/getUserInfo/" + token, null);
            JSONObject unmarshal = JSON.unmarshal(result, JSONObject.class).getObj("data").getObj("accountVo");
            String avatar = unmarshal.getStr("userId");
            SysUser sysUser1 = new SysUser();
            sysUser1.setAvatar(avatar);
            List<SysUser> sysUser2 = iSysUserService.selectUserPojo(sysUser1);
            //通过userId找到该用户信息
            if (sysUser2.size() == 0) {
                throw new AuthenticationException();
            }
            sysUser = sysUser2.get(0);
            if (3==sysUser.getRoles().get(0).getRoleId()) {
                throw new UserPasswordNotMatchException();
            }
        } catch (UserPasswordNotMatchException e) {
            throw new UserPasswordNotMatchException ();
        } catch (AuthenticationException e) {
            throw new AuthenticationException();
        } catch (Exception e) {
            log.info("对用户[" + token + "]进行登录验证..验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, password, getName());
        return info;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}

