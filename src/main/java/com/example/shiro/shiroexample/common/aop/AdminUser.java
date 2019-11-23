package com.example.shiro.shiroexample.common.aop;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户实体
 * @Author: chenping
 * @Date: 2019-11-20
 */
@Data
@NoArgsConstructor
public class AdminUser {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 管理员用户名
     */
    private String adminUsername;

    /**
     * 管理员类型
     */
    private Integer userType;

}
