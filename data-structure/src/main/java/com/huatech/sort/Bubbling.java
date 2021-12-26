package com.huatech.sort;


import java.util.Arrays;

/**
 * @author Songxianyang
 * @description: 冒泡排序
 * @create: 2021-12-26 16:18
 **/
public class Bubbling {
    public static void main(String[] args) {
        int[] array = {10, 5, -1, 9, 30, 83, -4};


        //第一趟排序
        //j表示你循环趟数-1
        for (int j = 0, sizeNext = array.length-1; j < sizeNext; j++) {
            //i=元素个数
            //array.length-j-1 表示：总长度-排序的个数-趟数
            //第一趟 当前的
            //第二趟 j=1表示第二趟   长度-1
            for (int i = 0, size = sizeNext-j; i < size; i++) {
                //下一个索引下标
                int tmp = i + 1;
                //获取当前值  当前值我们就不会去替换位置  所以用不上这个
                int index = array[i];
                //获取下一个值  因为我们要获取下一个值 去替换上一个值   上来先定义一个值作为 开始值  不会发生改变
                int next = array[tmp];

                if (array[i] > array[tmp]) {
                    //替换位置
                    array[tmp] = array[i];
                    array[i] = next;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
