package com.fszn.web.controller.system;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fszn.common.exception.user.UserPasswordNotMatchException;
import com.fszn.common.json.JSON;
import com.fszn.common.json.JSONObject;
import com.fszn.common.utils.ServletUtils;
import com.fszn.common.utils.http.HttpUtils;
import com.fszn.common.utils.security.Md5Utils;
import com.fszn.framework.shiro.realm.MyUsernamePasswordToken;
import com.fszn.framework.util.ShiroUtils;
import com.fszn.system.domain.SysUser;
import com.fszn.system.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.StringUtils;

import java.util.zip.DataFormatException;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@Controller
public class SysLoginController extends BaseController {
    @Autowired
    private  ISysUserService iSysUserService;
    @GetMapping("/login")
    /**
     * 功能描述: 游客登录
     * 1、直接获取token  2、判断第一次登录   添加数据库 3、返回至不同页面
     * @param token
     * @param request
     * @param response
     * @return: java.lang.String
     * @Author: 阿江
     * @Date: 2020/10/12 10:29
     */
    public String login(String token, HttpServletRequest request, HttpServletResponse response) {
            //判断参数为几个，---即 判断 使用哪个Relam
            MyUsernamePasswordToken myUsernamePasswordToken = new MyUsernamePasswordToken(token, null, "Tourist");
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(myUsernamePasswordToken);
                return "forward:/page/user/index.html";
            } catch (UserPasswordNotMatchException e) {
                //该用户在数据库当中注册过  商家---转发至商家登录界面
                return "forward:/page/login/login_register.html";
            }catch (AuthenticationException  e) {
                //空指针异常代表数据库当中没有该用户的数据 需注册
                return "forward:/page/login/login_register.html?token="+token;
            }catch (Exception e) {
                //未知异常
                return "forward:/page/error/404.html";
            }
        }


    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String user, String passwd, Boolean rememberMe) {
        MyUsernamePasswordToken token = new MyUsernamePasswordToken(user, passwd, "User");
        if (rememberMe != null) {
            token.setRememberMe(rememberMe);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return success();
        } catch (AuthenticationException e) {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage())) {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }
    @GetMapping("/unauth")
    public String unauth() {
        return "error/unauth";
    }
}
