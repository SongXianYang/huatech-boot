package com.huatech.spring.ioc;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-07 19:17
 **/
public class StringMain {
    public static void main(String[] args) {
        Class<TestMain> aClass = TestMain.class;
        //获取包路径
        String s = aClass.getPackage().getName() + ".";
        System.out.println(s);
        //获取类的全路径
        String name = aClass.getName();
        System.out.println(name);

        //替换
        String s1 = name.replaceAll(s,"");
        System.out.println(s1);

    }
}
