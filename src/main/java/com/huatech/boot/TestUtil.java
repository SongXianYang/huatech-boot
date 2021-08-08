package com.huatech.boot;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.BeanUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @description: 测试工具类
 * @author: SongXY
 * @create: 2021-04-01 10:52
 **/
public class TestUtil {
    public static void main(String[] args) {
        DateTime date = DateUtil.date();
        System.out.println(date);
        Date date1 = new Date();
        System.out.println("date1 = " + date1);

        Date date2 = DateUtil.date(Calendar.getInstance());
        System.out.println(date2);
        String i = "2";


        if (i.equals("1") || i.equals("2")) {
            System.out.println(i);
        }
    }
}
