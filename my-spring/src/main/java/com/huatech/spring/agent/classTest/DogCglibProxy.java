package com.huatech.spring.agent.classTest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: 类的代理
 * @author: SongXY
 * @create: 2021-08-20 16:23
 **/
public class DogCglibProxy implements MethodInterceptor {
    //目标对象
    private Object object;

    public DogCglibProxy(Object object) {
        this.object = object;
    }

    //给目标对象创建一个代理对象
    public Object getCglibProxy() {
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(object.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行之前---------");
        Object obj = method.invoke(object,objects);
        System.out.println("或者方法执行之后----------");
        return obj;
    }
}
