package com.example.shiro.shiroexample.controller;

import com.example.shiro.shiroexample.common.AdminUser;
import com.example.shiro.shiroexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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

    /**
     * @Description:  test接口在shiro拦截方法中设置为不拦截，不用登录就可以方法此接口
     * @param:
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: chenping
     * @Date: 2019/11/21
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView pay(String ticket, AdminUser adminUser) {
        log.info("AdminUser: {}",adminUser);
        String loginName = (String) SecurityUtils.getSubject().getPrincipal();
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        log.info("loginName:{}",loginName);
        ModelAndView mv = new ModelAndView("test");
        return mv;
    }

}
