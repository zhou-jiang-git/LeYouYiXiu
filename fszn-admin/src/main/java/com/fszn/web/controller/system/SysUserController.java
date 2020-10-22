package com.fszn.web.controller.system;

import java.util.ArrayList;
import java.util.List;

import com.fszn.common.json.JSON;
import com.fszn.common.json.JSONObject;
import com.fszn.common.utils.StringUtils;
import com.fszn.common.utils.http.HttpUtils;
import com.fszn.framework.shiro.realm.MyUsernamePasswordToken;
import com.fszn.framework.shiro.realm.Roles;
import com.fszn.system.domain.SysRole;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.fszn.common.annotation.Log;
import com.fszn.common.constant.UserConstants;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.core.page.TableDataInfo;
import com.fszn.common.enums.BusinessType;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.framework.shiro.service.SysPasswordService;
import com.fszn.framework.util.ShiroUtils;
import com.fszn.system.domain.SysUser;
import com.fszn.system.service.ISysPostService;
import com.fszn.system.service.ISysRoleService;
import com.fszn.system.service.ISysUserService;

/**
 * 用户信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser user)
    {
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user)
    {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = ShiroUtils.getSysUser().getLoginName();
        String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 新增用户
     */
//    @GetMapping("/add")
//    public String add(ModelMap mmap)
//    {
//        mmap.put("roles", roleService.selectRoleAll());
//        mmap.put("posts", postService.selectPostAll());
//        return prefix + "/add";
//    }

    /**
     * 新增保存用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String user, String passwd,String token)
    {
        try {
            //  判断账号是否已经被注册
            String result = HttpUtils.sendGet("https://sso.ahzwfw.gov.cn/uccp-service/user/getUserInfo/" + token, null);
            JSONObject unmarshal = JSON.unmarshal(result, JSONObject.class).getObj("data").getObj("accountVo");
            String avatar = unmarshal.getStr("userId");
            String userName = unmarshal.getStr("userName");
            String phone = unmarshal.getStr("phone");
            SysUser sysUser = new SysUser();
            sysUser.setAvatar(avatar);
            sysUser.setPhonenumber(phone);
            List<SysUser> sysUsers = userService.selectUserList(sysUser);
            if(sysUsers.size()>0){
                return error("您已注册过了无法再注册");
            }
            if(userService.checkLoginNameUnique(user).equals(UserConstants.USER_NAME_NOT_UNIQUE)){
                return error("用户名已重复");
            }
            sysUser.setSalt(ShiroUtils.randomSalt());
            sysUser.setLoginName(user);
            sysUser.setUserName(userName);
            sysUser.setRoleId((long) 3);
            sysUser.setPassword(passwordService.encryptPassword(sysUser.getLoginName(), passwd, sysUser.getSalt()));
            return toAjax(userService.insertUser(sysUser));
        } catch (Exception e) {
            String msg = "账号已被注册或密码过于简单";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @GetMapping("/add")
    @ResponseBody
    public AjaxResult addSave1(String token)
    {
        try {
            String result = HttpUtils.sendGet("https://sso.ahzwfw.gov.cn/uccp-service/user/getUserInfo/" + token, null);
            JSONObject unmarshal = JSON.unmarshal(result, JSONObject.class).getObj("data").getObj("accountVo");
            String avatar = unmarshal.getStr("userId");
            String userName = unmarshal.getStr("userName");
            SysUser sysUser = new SysUser();
            sysUser.setAvatar(avatar);
            sysUser.setRoleId((long) 2);
            sysUser.setUserName(userName);
            return toAjax(userService.insertUser(sysUser));
        } catch (Exception e) {
            String msg = "免密注册异常";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));
        mmap.put("posts", postService.selectPostsByUserId(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysUser user)
    {
        userService.checkUserAllowed(user);
        if (UserConstants.USER_PHONE_NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return error("修改用户'" + user.getLoginName() + "'失败，手机号码已存在");
        }
        else if (UserConstants.USER_EMAIL_NOT_UNIQUE.equals(userService.checkEmailUnique(user)))
        {
            return error("修改用户'" + user.getLoginName() + "'失败，邮箱账号已存在");
        }
        user.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(userService.updateUser(user));
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user)
    {
        userService.checkUserAllowed(user);
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        if (userService.resetUserPwd(user) > 0)
        {
            if (ShiroUtils.getUserId() == user.getUserId())
            {
                ShiroUtils.setSysUser(userService.selectUserById(user.getUserId()));
            }
            return success();
        }
        return error();
    }
    @Log(title = "修改密码", businessType = BusinessType.UPDATE)
    @PostMapping("/forgetPwd")
    @ResponseBody
    public AjaxResult forgetPwdSave(String user,String passwd,String phone,String token)
    {
        try {
            //  判断账号是否已经被注册
            String result = HttpUtils.sendGet("https://sso.ahzwfw.gov.cn/uccp-service/user/getUserInfo/" + token, null);
            JSONObject unmarshal = JSON.unmarshal(result, JSONObject.class).getObj("data").getObj("accountVo");
            String avatar = unmarshal.getStr("userId");
            SysUser sysUser = new SysUser();
            sysUser.setAvatar(avatar);
            List<SysUser> sysUsers = userService.selectUserPojo(sysUser);
            if(sysUsers.size()==0){
                return error("您目前尚未注册，请选择注册");
            }
            if(!sysUsers.get(0).getPhonenumber().equals(phone)){
                 return error("请正确输入您在皖氏通账号注册的手机号码");
            }
            if(!sysUsers.get(0).getLoginName().equals(user)){
                return error("请正确输入您在皖氏通账号注册的登录名");
            }
            sysUser=sysUsers.get(0);
            sysUser.setSalt(ShiroUtils.randomSalt());
            sysUser.setRoleId((long) 3);
            sysUser.setPassword(passwordService.encryptPassword(sysUser.getLoginName(), passwd, sysUser.getSalt()));
            userService.updateUserInfo(sysUser);

            //进行登录操作
            MyUsernamePasswordToken myUsernamePasswordToken = new MyUsernamePasswordToken(user,passwd, "User");
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(myUsernamePasswordToken);
                return success();
            } catch (AuthenticationException e) {
                String msg = "登录异常";
                if (StringUtils.isNotEmpty(e.getMessage())) {
                    msg = e.getMessage();
                }
                return error(msg);
            }
        } catch (Exception e) {
            String msg = "未知异常，请稍后访问";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user)
    {
        return userService.checkEmailUnique(user);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysUser user)
    {
        userService.checkUserAllowed(user);
        return toAjax(userService.changeStatus(user));
    }
}