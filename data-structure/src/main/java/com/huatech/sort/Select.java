package com.huatech.sort;

import java.util.Arrays;

/**
 * @author Songxianyang
 * @description: 选择排序
 * @create: 2021-12-26 20:52
 **/
public class Select {
    public static void main(String[] args) {
        int[] arr = {90, 543, -67, 4, -45};
        //一共多少轮循环
        for (int j = 0, size = arr.length - 1; j < size; j++) {
            //定义下一个最小数下标
            int min = j;
            //获取到下一个最小数
            int oneNum = arr[j];
            //第一轮选出最小的排在第一位
            for (int i = 0, sizeNum = size-j; i < sizeNum; i++) {
                int iNum=i+1;
                //判断大小值   改变位置
                if (arr[min] > arr[iNum]) {
                    min = i;
                }
                //两个值不能相同 相等的时候还交换就没意义了
                if (min != iNum) {
                    arr[j] = arr[min];
                    arr[min] = oneNum;
                }
            }
        }
        ////定义下一个最小数下标
        //int min = 0;
        ////获取到下一个最小数
        //int oneNum = arr[0];
        ////第一轮选出最小的排在第一位
        //for (int i = 1, sizeNum = arr.length; i < sizeNum; i++) {
        //    //判断大小值   改变位置
        //    if (arr[min] > arr[i]) {
        //        min = i;
        //    }
        //    //两个值不能相同 相等的时候还交换就没意义了
        //    if (min != i) {
        //        arr[0] = arr[min];
        //        arr[min] = oneNum;
        //    }
        //
        //}
        System.out.println(Arrays.toString(arr));
    }
}
