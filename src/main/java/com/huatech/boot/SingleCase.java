package com.huatech.boot;

import lombok.val;

/**
 * @description: 单例
 * @author: SongXY
 * @create: 2021-04-22 20:28
 **/
public class SingleCase {
    private static final SingleCase EXAMPLE = new SingleCase();

    private SingleCase() {
    }

    public void test() {
        System.out.println("00000000000000");
    }

    public static SingleCase getExample() {
        return EXAMPLE;
    }

    public static void main(String[] args) {
        SingleCase example = SingleCase.getExample();
        SingleCase example1 = SingleCase.getExample();
        System.out.println(example == example1);
    }
}
