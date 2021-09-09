package com.huatech.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-06 10:16
 **/
public class MainTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);

        list.add("1");
        list.add("2");
        list.add("--3--");
        System.out.println(list);

        Map<Integer, String> map = new HashMap<>(5);
    }
}
