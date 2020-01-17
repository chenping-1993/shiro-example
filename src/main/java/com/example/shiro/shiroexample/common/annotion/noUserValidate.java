package com.example.shiro.shiroexample.common.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 加此注解，controller类中的public方法不需要校验用户信息，接口方法中不需要加入 AdminUser，
 * 不加此注解，则接口public方法中必须加入AdminUser，需要校验登录的用户，获取AdminUser
 * 总之，不想要获取AdminUser，则加此注解；想要获取AdminUser，则不加此注解
 * @Author: chenping
 * @Date: 2019-11-23
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
public @interface noUserValidate {
}
