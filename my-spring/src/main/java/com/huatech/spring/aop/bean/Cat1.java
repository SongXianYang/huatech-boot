package com.huatech.spring.aop.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-18 20:04
 **/
@Component
@Data
public class Cat1 {
    private int id;
    private String name;
    public void testCat(int Iid,String nameN) {
        this.setName(nameN);
        this.setId(Iid);
        System.out.println(id+name);
    }
}
