package com.huatech.boot.design23.abstractFactoryPattern.impl;

import com.huatech.boot.design23.abstractFactoryPattern.Router;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-24 13:05
 **/
public class XiaoMiRouterImpl implements Router {
    @Override
    public void settings() {
        System.out.println("小米路由器设置");
    }

    @Override
    public void wifi() {
        System.out.println("小米路由器超强wifi");
    }
}
