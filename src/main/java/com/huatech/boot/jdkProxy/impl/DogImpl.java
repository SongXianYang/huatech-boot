package com.huatech.boot.jdkProxy.impl;

import com.huatech.boot.jdkProxy.Dog;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-27 19:55
 **/
public class DogImpl implements Dog {

    @Override
    public String eat(String name) {
        return name;
    }

    @Override
    public String drink(String name) {
        return name;
    }
}
