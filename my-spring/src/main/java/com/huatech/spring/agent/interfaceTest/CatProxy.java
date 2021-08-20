package com.huatech.spring.agent.interfaceTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 猫猫代理类
 * @author: SongXY
 * @create: 2021-08-20 16:09
 **/

public class CatProxy implements InvocationHandler {

    private Object object;

    public CatProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行之前");
        Object obj = method.invoke(object, args);
        System.out.println("或者方法执行之后");
        //返回代理对象
        return obj;
    }
}
