package com.example.shiro.shiroexample.enums;

/**
 * @Author: chenping
 * @Date: 2019/8/21
 */
public enum SessionConst {

    /**
     * 用户ID
     */
    SESSION_USER_ID ("session_user_id"),

    /**
     * 用户名
     */
    SESSION_USER_NAME ("session_user_name"),

    /**
     * 角色ID
     */
    SESSION_ROLE_ID ("session_role_id");

    private String msg;

    SessionConst(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
