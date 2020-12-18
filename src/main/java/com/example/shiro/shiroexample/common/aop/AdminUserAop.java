package com.example.shiro.shiroexample.common.aop;

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
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * 接口日志注入切面类
 * @Author: chenping
 * @Date: 2019-11-21
 */
@Slf4j
@Aspect
@Component
public class AdminUserAop {

    @Autowired
    ShiroSessionService shiroSessionService;

    public AdminUserAop() {

    }

    /**
     * @Description:  配置切面的作用域
     *     * com.example.shiro.shiroexample.controller.*.*(..))     作用于 controller包下的所有方法
     *     * com.example.shiro.shiroexample.controller..*.*(..))    作用于 controller包及其所有子包下的所有方法
     * @param:
     * @return: void
     * @Author: chenping
     * @Date: 2019/11/23
     */
    @Pointcut("execution(public * com.example.shiro.shiroexample.controller..*.*(..))")
    public void allControllerMethod() {

    }

    /**
     * @Description:  aroundMethod 方法参数注入逻辑
     * @param: point 切面方法
     * @return: java.lang.Object
     * @Author: chenping
     * @Date: 2019/11/23
     */
    @SuppressWarnings("rawtypes")
    @Around("allControllerMethod()")
    public Object aroundMethod(ProceedingJoinPoint point) throws Throwable {
        Object target = point.getTarget(); //拦截的实体类
        Object[] args = point.getArgs();//拦截的方法参数
        //拦截的方法参数类型
        Class[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        String methodName = point.getSignature().getName();//拦截的方法名称

        Method method = target.getClass().getMethod(methodName, parameterTypes);//通过反射获得拦截的method
        Date now = new Date();
        RequestMapping request = method.getAnnotation(RequestMapping.class);
        if (!StringUtils.isEmpty(request)) {
            log.info("调用接口：{}", Arrays.toString(request.value()));
        }
        long beginTime = System.currentTimeMillis();
        log.info("开始调用: {}.{}, 时间: {}", point.getSignature().getDeclaringTypeName(), methodName,
                now);

        // 封装用户信息
        String loginUserName = shiroSessionService.getUserName();
        log.info("操作用户：{}",loginUserName);
//        args[0] = userVo;//在方法的第一个参数放入 AdminUser userVo
        Object proceed = point.proceed();
        long endTime = System.currentTimeMillis();
        // 接口调用时间log
        log.info("结束调用 {}.{}, 总耗时: {} ms", point.getSignature().getDeclaringTypeName(), methodName,
                endTime - beginTime);
        // 返回值log
        log.info("接口返回结果: {}", JSON.toJSONString(proceed, SerializerFeature.WriteNullStringAsEmpty));
        return proceed;
    }

}
