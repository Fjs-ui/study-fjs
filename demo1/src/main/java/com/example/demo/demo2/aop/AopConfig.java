package com.example.demo.demo2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @description:
 * @author: fjs
 * @create: 2022-02-08 16:47
 **/
@Aspect
@Component
public class AopConfig {
    //定义日志输出
    private Logger logger= LoggerFactory.getLogger(AopConfig.class);


    //定义切入点
    @Pointcut("execution(public * com.example.demo.demo2.controller.TestController*.*(..))")
    public void aopPoint(){

    }

    //前置通知：在连接点执行之前的通知
    @Before("aopPoint()")
    public void doBefore(JoinPoint joinPoint){
        //收到请求获取请求内容
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret",pointcut = "aopPoint()")
    public void doAfter(Object ret){
        logger.info("返回结果",ret);
    }

}
