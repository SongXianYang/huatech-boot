package com.huatech.boot.entity;

import lombok.Data;

/**
 * @description: 猫实体
 * @author: SongXY
 * @create: 2021-08-02 15:30
 **/
@Data
public class Cat {
    private int id;
    private String name;
    private int age;
    private String sex;
}
