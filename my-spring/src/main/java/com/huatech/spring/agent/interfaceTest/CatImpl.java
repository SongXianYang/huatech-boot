package com.huatech.spring.agent.interfaceTest;

import com.huatech.spring.agent.Cat;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-20 16:04
 **/
public class CatImpl implements Cat {
    @Override
    public void play(String name) {
        System.out.println(name+"-在玩！！");
    }
}
