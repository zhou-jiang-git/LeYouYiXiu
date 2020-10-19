package com.fszn.framework.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName MyModularRealmAuthenticator
 * @Description TODO
 * @Author 阿江
 * @Date 2020/10/13 15:56
 * @Version 1.0
 */
public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
    private static final Logger log = LoggerFactory.getLogger(ModularRealmAuthenticator.class);

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        MyUsernamePasswordToken userToken = (MyUsernamePasswordToken) authenticationToken;
        // 登录类型
        String loginType = userToken.getLoginType();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(loginType)) {
                typeRealms.add(realm);
            }
        }

        // 判断是单Realm还是多Realm
        if (typeRealms.size() == 1) {
            //单realm处理
            return doSingleRealmAuthentication(((ArrayList<Realm>) typeRealms).get(0), userToken);
        } else {
            //多realm处理，需满足全部realm认证
            return doMultiRealmAuthentication(typeRealms, userToken);
        }
    }

    /**
     * 重写doMultiRealmAuthentication，修复多realm联合认证只出现AuthenticationException异常，而未处理其他异常
     */
    protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) throws AuthenticationException {

        AuthenticationStrategy strategy = getAuthenticationStrategy();

        AuthenticationInfo aggregate = strategy.beforeAllAttempts(realms, token);

        if (log.isTraceEnabled()) {
            log.trace("Iterating through {} realms for PAM authentication", realms.size());
        }

        for (Realm realm : realms) {

            aggregate = strategy.beforeAttempt(realm, token, aggregate);

            if (realm.supports(token)) {

                log.trace("Attempting to authenticate token [{}] using realm [{}]", token, realm);

                AuthenticationInfo info = null;
                Throwable t = null;
                try {
                    info = realm.getAuthenticationInfo(token);
                } catch (Throwable throwable) {
                    t = throwable;
                    if (log.isDebugEnabled()) {
                        String msg = "Realm [" + realm + "] threw an exception during a multi-realm authentication attempt:";
                        log.debug(msg, t);
                    }
                }
                //处理只提示AuthenticationException异常问题
                if(t instanceof AuthenticationException) {
                    log.debug("realmName:"+realm.getName(), t);
                    throw (AuthenticationException)t;
                }
                aggregate = strategy.afterAttempt(realm, token, info, aggregate, t);

            } else {
                log.debug("Realm [{}] does not support token {}.  Skipping realm.", realm, token);
            }
        }

        aggregate = strategy.afterAllAttempts(token, aggregate);

        return aggregate;
    }
}
