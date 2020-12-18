package com.example.shiro.shiroexample.common.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 加此注解，controller类中的public方法可以获取登陆用户信息，接口方法中要加入 AdminUser，
 * 不加此注解，则接口public方法中不用加AdminUser，不获取AdminUser
 * 总之，想要获取登陆用户信息AdminUser，则加此注解；不想要获取AdminUser，则不加此注解
 * @Author: chenping
 * @Date: 2019-11-23
 */
@Deprecated
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
public @interface GetUserInformation {
}
