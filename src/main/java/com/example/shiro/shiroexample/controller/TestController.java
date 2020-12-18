package com.example.shiro.shiroexample.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.shiro.shiroexample.common.aop.AdminUser;
import com.example.shiro.shiroexample.entity.User;
import com.example.shiro.shiroexample.shiro.ShiroSessionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/** 测试控制类
 * @Author: chenping
 * @Date: 2019-11-20
 */
@RestController
@RequestMapping("/test")
@Scope(value = "prototype")
@Slf4j
public class TestController {

    @Autowired
    ShiroSessionService shiroSessionService;
    /**
     * @Description:  test接口在shiro拦截方法中设置为不拦截，不用登录就可以访问此接口
     * SecurityUtils 获取登陆用户信息
     * @param:
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: chenping
     * @Date: 2019/11/21
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(String id) {
        String loginName = (String) SecurityUtils.getSubject().getPrincipal();
        log.info("loginName:{}",loginName);
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        log.info("登陆用户信息：{}", JSONObject.toJSON(user));
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

    /** 
     * @Description:  获取登陆用户信息
     * @param: adminUser 
     * @return: com.example.shiro.shiroexample.entity.User 
     * @Author: chenping
     * @Date: 2020/12/18 14:59
     */
    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    public User test(AdminUser adminUser) {
        /**
         * 获取登陆用户信息
         */
        User user = shiroSessionService.getUser();
        log.info(" 获取登陆用户信息：{}", JSONObject.toJSON(user));
        return user;
    }

}
