package com.huatech.boot.design23.abstractFactoryPattern.impl;

import com.huatech.boot.design23.abstractFactoryPattern.Phone;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-24 13:05
 **/
public class XiaomiPhoneImpl implements Phone {
    @Override
    public void sendMessage() {
        System.out.println("小米手机发短信");
    }

    @Override
    public void playGames() {
        System.out.println("小米游戏打游戏");
    }
}
