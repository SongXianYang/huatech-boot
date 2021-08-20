package com.huatech.spring.aop;

import com.huatech.spring.aop.bean.Cat1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-10 13:59
 **/
@SpringBootApplication
public class DemoMain {

    public static void main(String[] args) {
        SpringApplication.run(DemoMain.class);
    }
}

