package com.example.shiro.shiroexample.controller;

import com.example.shiro.shiroexample.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author: chenping
 * @Date: 2019/8/21
 */
@RestController
public class UserController {

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
//        ModelAndView mv;
        //System.out.println(newUser.getName()+newUser.getPassword());
        //shiro用户认证
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken userToken = new UsernamePasswordToken(user.getName(),user.getPassword());
        //执行登录方法,用捕捉异常去判断是否登录成功
        try {
            subject.login(userToken);
            mv = new ModelAndView("sse");
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
