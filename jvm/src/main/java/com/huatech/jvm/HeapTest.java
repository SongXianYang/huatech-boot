package com.huatech.jvm;

/**
 * @description: 堆 oom
 * 调优指令：-Xms1024m -Xmx1024 -XX:+PrintGCDetails
 * @author: SongXY
 * @create: 2021-11-24 16:54
 **/
public class HeapTest {
    public static void main(String[] args) {
        String s = "sxy";
        while (true) {
            s += s + s;
            System.out.println(s);
        }
    }

}
