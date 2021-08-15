package com.huatech.spring.aop.service;

import com.huatech.spring.annotation.ClassAnnotation;

/**
 * @description: 用户业务层
 * @author: SongXY
 * @create: 2021-08-15 18:19
 **/
@ClassAnnotation("用户业务层")
public class UserService {
    private Integer id;
    private String name;


    /**
     * 新增用户
     * @param id
     * @param name
     */
    public void seve(Integer id,String name) {
        System.out.println("id为："+id+","+"用户名："+name);
    }
}
