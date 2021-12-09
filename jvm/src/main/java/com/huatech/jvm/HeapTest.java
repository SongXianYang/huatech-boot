package com.huatech.jvm;

/**
 * @description: 堆 oom
 * -Xms 设置初始化内存大小
 * -Xmx 设置最大分配内存
 * 调优指令：-Xms1m -Xmx8m -XX:+PrintGCDetails   打印GC回收信息
 * -XX:+HeapDumpOnOutOfMemoryError   分析：堆的信息 dump文件 （打印什么错位的dump文件）OutOfMemoryError
 * @author: SongXY
 * @create: 2021-11-24 16:54
 *
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
