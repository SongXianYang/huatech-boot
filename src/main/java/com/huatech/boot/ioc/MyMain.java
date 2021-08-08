package com.huatech.boot.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: ioc测试
 * @author: SongXY
 * @create: 2021-08-06 22:17
 **/
public class MyMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.huatech.boot.ioc");
        //获取原材料组件
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
            System.out.println("---------------");
            System.out.println(applicationContext.getBean(beanDefinitionName));
        }
    }
}
