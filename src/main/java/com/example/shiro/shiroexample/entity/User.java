package com.example.shiro.shiroexample.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
@Data
@TableName(value = "user_shiro")//指定表名
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String perms;
}
