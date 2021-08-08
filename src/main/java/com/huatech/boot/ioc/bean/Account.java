package com.huatech.boot.ioc.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-06 22:17
 **/
@Component
@Data
public class Account {
    @Value("1")
    private int id;
    @Value("sxy")

    private String name;
    @Value("23")

    private int age;

    @Resource
    private Order order;
}
