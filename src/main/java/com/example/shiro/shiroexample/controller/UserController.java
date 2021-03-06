package com.example.shiro.shiroexample.controller;

import com.example.shiro.shiroexample.common.util.StringUtils;
import com.example.shiro.shiroexample.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author: chenping
 * @Date: 2019/8/21
 */
@RestController
public class UserController {

    //加密的salt
    @Value("${md5salt}")
    public String md5salt;
    /**
     * 登录后才可以访问页面
     * @return
     */
    @RequestMapping("one")
    public ModelAndView getOne(){
        ModelAndView mv = new ModelAndView("one");
        return mv;
    }
    @RequestMapping("two")
    public ModelAndView getTwo(){
        ModelAndView mv = new ModelAndView("two");
        return mv;
    }
    @RequestMapping("three")
    public ModelAndView getThree(){
        ModelAndView mv = new ModelAndView("three");
        return mv;
    }

    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * 若是没有页面权限，进入无权限提示页面
     * @return
     */
    @RequestMapping("permission")
    public ModelAndView permission(){
        ModelAndView mv = new ModelAndView("permission");
        return mv;
    }

    @RequestMapping("toLogin")
    public ModelAndView toLogin(User user){

        ModelAndView mv = new ModelAndView("login");
        if (StringUtils.isEmpty(user)) {
            return mv;
        }
//        ModelAndView mv;
        //System.out.println(newUser.getName()+newUser.getPassword());
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        //密码两次md5加密
        String md5Password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        String secondEncodePwd = DigestUtils.md5DigestAsHex((md5Password+md5salt).getBytes());
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),secondEncodePwd);

        // 已经登录过了
        if (subject.isAuthenticated()) {
            subject.logout();
        }

        //执行登录方法,用捕捉异常去判断是否登录成功
        try {
            subject.login(userToken);
            mv = new ModelAndView("index");
            return mv;
        } catch (UnknownAccountException e) {
            //用户名不存在
//            mv = new ModelAndView("login");
            mv.addObject("msg","用户名不存在");
            return mv;
        }catch (IncorrectCredentialsException e) {
            //密码错误
            mv.addObject("msg","密码错误");
            return mv;
        }

    }
}
