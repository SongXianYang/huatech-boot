package com.huatech.boot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 测试时间区间
 * @author: SongXY
 * @create: 2021-09-16 21:08
 **/
public class TestTime {

    public static void main(String[] args) {
        System.out.println(isOverlap( "2020-01-13", "2020-02-13","2021-01-13", "2021-09-13"));
    }

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

//    HH:mm:ss

    private static boolean isOverlap(String startdate1, String enddate1, String startdate2, String enddate2) {
        //开始时间
        Date leftStartDate = null;
        Date leftEndDate = null;
        //比较时间
        Date rightStartDate = null;
        Date rightEndDate = null;
        try {
            leftStartDate = format.parse(startdate1);
            leftEndDate = format.parse(enddate1);
            rightStartDate = format.parse(startdate2);
            rightEndDate = format.parse(enddate2);
        } catch (ParseException e) {
            return false;
        }

        return
                ((leftStartDate.getTime() >= rightStartDate.getTime())
                        && leftStartDate.getTime() < rightEndDate.getTime())
                        ||
                        ((leftStartDate.getTime() > rightStartDate.getTime())
                                && leftStartDate.getTime() <= rightEndDate.getTime())
                        ||
                        ((rightStartDate.getTime() >= leftStartDate.getTime())
                                && rightStartDate.getTime() < leftEndDate.getTime())
                        ||
                        ((rightStartDate.getTime() > leftStartDate.getTime())
                                && rightStartDate.getTime() <= leftEndDate.getTime());

    }
}
