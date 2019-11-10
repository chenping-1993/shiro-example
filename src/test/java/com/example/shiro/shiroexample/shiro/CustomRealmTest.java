package com.example.shiro.shiroexample.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 自定义realm测试类
 * @Author: chenping
 * @Date: 2019/8/18
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {
        CustomRealm customRealm = new CustomRealm();

        //1 创建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        //2 主题提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jack","111111");
        subject.login(usernamePasswordToken);//登录

        System.out.println("是否认证： -- "+subject.isAuthenticated());

//        subject.logout();//退出登录
//
//        System.out.println("是否认证： -- "+subject.isAuthenticated());

        subject.checkRole("admin");
        subject.checkPermissions("normalUser:add","normalUser:edit");//校验多权限

    }
}
