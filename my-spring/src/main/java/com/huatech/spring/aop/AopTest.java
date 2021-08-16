package com.huatech.spring.aop;

import com.huatech.spring.aop.service.UserService;
import com.huatech.spring.utils.ObjReflectionUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @description:  借助书籍 spring3.0
 *                      aop知识点
 *                  Java编程思想
 *                      注解
 *                      反射
 * @author: SongXY
 * @create: 2021-08-15 18:18
 **/
public class AopTest {
    public static void main(String[] args) throws ClassNotFoundException {
        AopTest aopTest = new AopTest();
        aopTest.testNotStatic();

        //获取userService属性
        Field[] fields = ObjReflectionUtil.getFields(UserService.class);
        for (Field field : fields) {
            //获取属性
            System.out.println(field);
            //获取类型
            System.out.println(field.getType());
            //获取属性名
            System.out.println(field.getName());
        }

        System.out.println("--------------------------------");

        //获取方法
        Method[] methods = ObjReflectionUtil.getMethods(UserService.class);
        for (Method method : methods) {
            System.out.println("method--"+method);
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            System.out.println(parameters.length);
        }


    }

    private void testNotStatic() throws ClassNotFoundException {
        UserService userService = (UserService) ObjReflectionUtil.newOgj(UserService.class);
        userService.seve(1,"sxy");
        System.out.println("_________________________");
    }

}
