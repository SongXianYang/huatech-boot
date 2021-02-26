package com.huatech.boot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author SongXianYang
 */
public class JavaLambda {
    public static void main(String[] args) {
        String[] str={"song","xian","yang","hui","liu","guo"};
        stringArray(str);
        anonymousInnerClass(str);
    }

    //采用Java8新特性 遍历数组与List
    private static void stringArray(String [] str) {
        //将数组转换成List
        List<String> list = Arrays.asList(str);
        //采用Lambda
        list.forEach(s -> {
            System.out.println(s+";");
        });
        System.out.println("---------------------");
        //普通循环的方式
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("Java8排序");
    }

    //匿名内部类采用Java8
    private static void anonymousInnerClass(String [] str) {
        List<String> list = Arrays.asList(str);
        //传统排序
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        //采用Java8排序
        list.sort((s1,s2)->(s1.compareTo(s2)));
        System.out.println(list);
        System.out.println("-----------------");



    }

}
