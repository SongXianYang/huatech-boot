package com.huatech.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-10 14:07
 **/
@Component
@Aspect
public class MyAspect {
    /**
     *
     */
    @Pointcut("within(com.huatech.spring.aop.controller.UserController)")
    private void logMethod() {

    }

    @Pointcut("execution(* com.huatech.spring.aop.controller.*.*(..))")
    private void dataAccessOperation() {}

    @Before("dataAccessOperation()")
    private void before() {
        System.out.println("前置通知！！！");
    }
}
