package com.huatech.spring.aop.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-06 10:11
 **/
@Data
public class UserBean implements Serializable {
    private static final long serialVersionUID = -8715261761026526566L;

    private int id;
    private String name;
}
