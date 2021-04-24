package com.huatech.boot.design23.abstractFactoryPattern.impl;

import com.huatech.boot.design23.abstractFactoryPattern.Phone;
import com.huatech.boot.design23.abstractFactoryPattern.ProduceFactory;
import com.huatech.boot.design23.abstractFactoryPattern.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-24 13:20
 **/
public class HUAWEIProduceFactoryImpl implements ProduceFactory {
    @Override
    public Phone phone() {
        return new HuaWeiPhoneImpl();

    }

    @Override
    public Router router() {
        return new HuaWeiRouterImpl();
    }
}
