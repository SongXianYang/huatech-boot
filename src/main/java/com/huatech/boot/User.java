package com.huatech.boot;

import lombok.Data;

/**
 * @author SongXianYang
 */
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private String sex;
    private int wage;

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String name, int age, String sex, int wage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.wage = wage;
    }
}
