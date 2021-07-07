package com.huatech.boot;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 遍历 map
 * @author: SongXY
 * @create: 2021-06-18 16:38
 **/
public class TestForeachMap {
    public static void main(String[] args) {
        Map<String, Integer> items = new LinkedHashMap<>(10);
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        
        for (Map.Entry<String ,Integer> maps  : items.entrySet()) {
            System.out.println(maps.getValue());
        }
        items.forEach((k,v)->{
            System.out.println(v);
            if ("A".equals(k)) {
                System.out.println("获取A的直");
            }
        });
    }
}
