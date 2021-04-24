package com.huatech.boot.design23.abstractFactoryPattern.impl;

import com.huatech.boot.design23.abstractFactoryPattern.Router;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-24 13:05
 **/
public class HuaWeiRouterImpl implements Router {
    @Override
    public void settings() {
        System.out.println("华为路由器设置");
    }

    @Override
    public void wifi() {
        System.out.println("华为路由器最强wifi");
    }
}
