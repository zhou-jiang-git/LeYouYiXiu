package com.fszn.framework.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @ClassName MyUsernamePasswordToken
 * @Description TODO
 * @Author 阿江
 * @Date 2020/10/13 15:57
 * @Version 1.0
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {
    private static final long serialVersionUID = 1L;
    //登录类型
    private String loginType;

    public MyUsernamePasswordToken(String username, final String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

}
