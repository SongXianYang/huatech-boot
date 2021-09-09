package com.huatech.spring.aop.aspect;

import com.huatech.spring.utils.ObjReflectionUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import com.huatech.spring.annotation.MethodAnnotation;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

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
    //所有controller下面的所有类中的所有方法

    @Pointcut("execution(* com.huatech.spring.aop.controller.*.*(..))")
    private void dataAccessOperation() {}

    /**
     * 切点    下面是连接点
     */
    @Pointcut("@annotation(com.huatech.spring.annotation.MethodAnnotation)")
    private void annotationMethod() {

    }

    @Before("dataAccessOperation()")
    private void before() {
        System.out.println("前置通知！！！");
    }

    @After("annotationMethod()")
    private void log(JoinPoint joinPoint) throws ClassNotFoundException {

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);

            Class<?> aClass = arg.getClass();


        }

        //获取目标对象
        Object targetObj =  joinPoint.getTarget();
        //获取到标有MethodAnnotation这个注解的方法
        List<Method> methods = ObjReflectionUtil.getMethodAnnotation(targetObj.getClass());

        for (Method method : methods) {
            MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
            String value = annotation.value();
            System.out.println("方法的功能名称 = " + value);
            String name = annotation.tableName();
            System.out.println("表名 = " + name);
            //如果有数据库即可执行插入日志表log插入
        }
    }
}
