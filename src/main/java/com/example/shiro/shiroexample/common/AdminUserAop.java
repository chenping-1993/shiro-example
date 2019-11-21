package com.example.shiro.shiroexample.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.shiro.shiroexample.shiro.ShiroSessionService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author: chenping
 * @Date: 2019-11-21
 */
@Slf4j
@Aspect
@Component
public class AdminUserAop {

    @Autowired
    private ShiroSessionService shiroSessionService;

    public AdminUserAop() {

    }

    @Pointcut("execution(public * com.example.shiro.shiroexample.controller.*.*.*(..))")
    public void allControllerMethod() {

    }

    @SuppressWarnings("rawtypes")
    @Around("allControllerMethod()")
    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable {
//        Object target = point.getTarget();
        Object[] args = point.getArgs();
//        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        String methodName = point.getSignature().getName();
//        if(null != methodName && "PingController".equals(methodName)){
//            Object proceed = point.proceed(args);
//            return proceed;
//        }
//        Method method = target.getClass().getMethod(methodName, parameterTypes);
        Date now = new Date();
        long beginTime = System.currentTimeMillis();
        log.info("开始调用类: {}, 方法: {}, 时间: {}", point.getSignature().getDeclaringTypeName(), methodName,
                now);
        // 自定义注解(筛选是否不需要用户校验)
//        noUserIntercept pass = method.getAnnotation(noUserIntercept.class);
//        if (!StringUtils.isEmpty(pass)) {
//            // 方法有此注解,不查询用户信息
//            long endTime = System.currentTimeMillis();
//            log.info("结束调用类: {}, 方法: {}, 总耗时: {} ms", point.getSignature().getDeclaringTypeName(), methodName,
//                    endTime - beginTime);
//            return point.proceed(args);
//        }
        // 校验ticket
        // 封装用户信息
        Integer userId = shiroSessionService.getUserId();
        String userName = shiroSessionService.getUserName();
        Integer userType = shiroSessionService.getRoleId();
        if (userId == null || StringUtils.isEmpty(userName)) {
            return new ModelAndView("login");
        }
        AdminUser userVo = new AdminUser();
        userVo.setUserId(userId);
        userVo.setAdminUsername(userName);
        userVo.setUserType(userType);
        args[1] = userVo;
        Object proceed = point.proceed(args);
        long endTime = System.currentTimeMillis();
        // 接口调用时间log
        log.info("结束调用类: {}, 方法: {}, 总耗时: {} ms", point.getSignature().getDeclaringTypeName(), methodName,
                endTime - beginTime);
        // 返回值log
        log.info("接口返回返回结果: {}", JSON.toJSONString(proceed, SerializerFeature.WriteNullStringAsEmpty));
        return proceed;
    }

}
