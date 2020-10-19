package com.fszn.framework.shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RetryLimitHashedCredentialsMatcher   免密登录
 * @Description TODO
 * @Author 阿江
 * @Date 2020/10/14 10:14
 * @Version 1.0
 */
@Configuration
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        MyUsernamePasswordToken tk = (MyUsernamePasswordToken) authcToken;
        //如果是免密登录直接返回true
        if(tk.getLoginType().equals("Tourist")){
            return true;
        }
        //不是免密登录，调用父类的方法
        return super.doCredentialsMatch(tk, info);
    }
}
