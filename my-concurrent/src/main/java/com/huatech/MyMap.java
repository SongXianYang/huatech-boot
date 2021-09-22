package com.huatech;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-21 16:44
 **/
public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(2);
        map.put(1, "song");
        map.put(2, "xian");
        map.put(3, "yang");
        System.out.println(map);
        System.out.println(map.size());
    }
}
