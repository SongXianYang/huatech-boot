package com.huatech.boot;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-06-23 16:51
 **/
public class Test01 {
    private static Integer integer;
    private static String string;

    public static void main(String[] args) {
        integer = 1;
        string = "1";
        System.out.println(integer.equals(Integer.parseInt(string)));
        System.out.println(testNullable(9999));
        testInt();
    }

    private static Integer testNullable(@NonNull int i) {
        return i;
    }

    private static void testInt() {
        int c[]={};
        c[0] = 1;
        System.out.println(c);
    }
}
