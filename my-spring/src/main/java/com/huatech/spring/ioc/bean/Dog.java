package com.huatech.spring.ioc.bean;

import com.huatech.spring.ioc.annotation.MyComponent;
import com.huatech.spring.ioc.annotation.MyValue;
import lombok.Data;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-07 17:57
 **/
@Data
@MyComponent("s")
public class Dog {
    @MyValue("1")
    private Integer id;
    @MyValue("可爱狗狗")
    private String name;
}
