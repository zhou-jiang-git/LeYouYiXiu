package com.fszn.common.exception.user;

import com.fszn.common.exception.base.BaseException;
import org.apache.shiro.authc.AuthenticationException;

/**
 * @ClassName ChooseRolesException
 * @Description 角色选择出现的判断工具异常
 * @Author 阿江
 * @Date 2020/10/20 9:06
 * @Version 1.0
 */
public class ChooseRolesException extends AuthenticationException {
    private static final long serialVersionUID = 1L;


    public ChooseRolesException()
    {
        super("user.choose.roles", null);
    }
}
