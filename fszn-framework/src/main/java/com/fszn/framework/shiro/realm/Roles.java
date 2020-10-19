package com.fszn.framework.shiro.realm;

public enum Roles {
    admin("1","管理员用户"),tourist("2","游客") ,bussiness("3","商家");

    private final String code;
    private final String info;

    Roles(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
