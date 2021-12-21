package com.huatech.netty;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author Songxianyang
 * @description:
 * @create: 2021-12-13 22:31
 **/
public class ByteBuffer1 {
    public static void main(String[] args) {
        //字符串与ByteBuffer转换
        java.nio.ByteBuffer buffer = StandardCharsets.UTF_8.encode("song/nxian/ny");

        System.out.println(buffer);


        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        byteBuffer.put("song/xian/y".getBytes());
        byteBuffer.put("ang".getBytes());
        byteBuffer.flip();
        System.out.println(byteBuffer);

        for (int i = 0, size = byteBuffer.limit(); i < size; i++) {
            if (byteBuffer.get(i) == '/') {
                int lang = i-1;
                ByteBuffer byteBuffer1 = ByteBuffer.allocate(lang);

                for (int j = 0, size2 = lang; j < size2; j++) {
                    byteBuffer1.put(byteBuffer.get());
                }
                System.out.println((char)byteBuffer1.get(1));
            }
        }
        byteBuffer.compact();
    }

}
