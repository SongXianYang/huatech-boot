package com.huatech.boot.design23;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-04-23 16:33
 **/
@Slf4j
public class Dome {
    public static void main(String[] args) {
        isUserVip(1);
        VipFactory factory = new VipFactory();
        Vip vip = factory.getVip(2);
        vip.isUserVip();
    }

    /**
     * @Description: 用户类型
     * @Param: [userType]
     * @return: void
     */
    private static void isUserVip(Integer userType) {
        log.info("方法调用开始参数为:{}", userType);

        if (userType.equals(1)) {
            System.out.println("vip用户业务");
        } else if (userType.equals(2)) {
            System.out.println("超级vip用户业务");
        } else {
            System.out.println("普通用户业务");
        }
    }
}

interface Vip {
    void isUserVip();
}

class VipUser implements Vip {

    @Override
    public void isUserVip() {
        System.out.println("vip用户业务");
    }
}

class SVipUser implements Vip {

    @Override
    public void isUserVip() {
        System.out.println("超级vip用户业务");
    }
}

class CommonUser implements Vip {

    @Override
    public void isUserVip() {
        System.out.println("普通用户业务");
    }
}

class VipFactory {
    private static Map<Integer, Vip> map = new HashMap();

    static {
        map.put(1, new VipUser());
        map.put(2, new SVipUser());
        map.put(3, new CommonUser());
    }

    public Vip getVip(Integer userType) {
        return map.get(userType);
    }
}