package com.huatech.boot.ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-06 22:37
 **/
@Component
@Data
public class Order {
    @Value("2")
    private int id;
    @Value("Order")

    private String name;
    @Value("2121")

    private int age;
}
