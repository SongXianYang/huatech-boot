package com.huatech.boot;


import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author SongXianYang
 */
@Log4j2
public class JavaStream {
    public static void main(String[] args) {
        User user = new User(1, "song", 21, "女", 1000);
        User user2 = new User(2, "song2", 22, "男", 2000);
        User user3 = new User(3, "song3", 89, "男", 3000);
        User user4 = new User(4, "song4", 24, "女", 4000);
        User user5 = new User(4, "song4", 9, "女", 4000);
        List<User> userList = new ArrayList();
        userList.add(user2);
        userList.add(user);
        userList.add(user4);
        userList.add(user3);

        System.out.println();


//        List<User> collect = userList.stream().filter(u -> !u.getId().equals(2)).collect(Collectors.toList());
//        System.out.println("collect = " + collect);
        //降序
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getAge).reversed()).limit(1).collect(Collectors.toList());

        System.out.println(collect.get(0));
//        //stream 表达式抽取一个字符作为一个集合
//        List<Integer> ids = userList.stream().map(User::getAge).collect(Collectors.toList());
//        System.out.println(ids);
//
//        //给用户加工资
//        Consumer<User> plusWages = u -> u.setWage(u.getWage() + 500);
//        userList.forEach(plusWages);
//
//        //Lambda表达式循环打印
//        userList.forEach(u -> {
//            System.out.println(u);
//        });
//        System.out.println("-----------------------");
//        //过滤一下工资小于3000的人员
//        List<User> collect1 = userList.stream().filter(u -> (u.getWage() >= 3000)).collect(Collectors.toList());
//        System.out.println(collect1);
//
//        System.out.println("过滤一下工资小于2000且性别是男性");
//        //
//        Predicate<User> filterWage = u -> (u.getWage() > 2000);
//        Predicate<User> filterSex = u -> ("男".equals(u.getSex()));
//        List<User> collect2 = userList.stream().filter(filterWage).filter(filterSex).collect(Collectors.toList());
//        System.out.println(collect2);
//
//        System.out.println("我只要集中的第一条数据");
//        List<User> collect3 = userList.stream().limit(1).collect(Collectors.toList());
//        System.out.println(collect3);
//
//        log.info("根据工资比较进行排序");
//        List<User> collect4 = userList.stream().sorted(((o1, o2) -> (o1.getWage() - o2.getWage()))).collect(Collectors.toList());
//        System.out.println(collect4);
//        log.info("根据name排序要前两条");
//        List<User> collect5 = userList.stream().sorted((o1, o2) -> (o1.getName().compareTo(o2.getName()))).limit(2).collect(Collectors.toList());
//        System.out.println(collect5);
//
//        log.info("工资最低的用户");
//        User userMin = userList.stream().min((o1, o2) -> (o1.getWage() - o2.getWage())).get();
//        System.out.println(userMin);
//        log.info("工资最高的用户");
//        User userMax = userList.stream().max((o1, o2) -> (o1.getWage() - o2.getWage())).get();
//        System.out.println(userMax);
//
//        log.info("集合对象中name抽取出来进行字符串*拼接");
//        String collect6 = userList.stream().map(User::getName).collect(Collectors.joining("*"));
//        System.out.println(collect6);
//        log.info("集合对象中name抽取出来放进set集合中");
//        Set<String> collect7 = userList.stream().map(User::getName).collect(Collectors.toSet());
//        System.out.println(collect7);
//        log.info("集合对象中name抽取出来放进TreeMap集合中");
//        TreeSet<String> collect8 = userList.stream().map(User::getName).collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(collect8);
//
//        log.info("所有人wage总和");
//        int sum = userList.stream().mapToInt(User::getWage).sum();
//        System.out.println(sum);
//        log.info("一个集合中的 count min max sum");
//        IntSummaryStatistics intSummaryStatistics = userList.stream().mapToInt(User::getWage).summaryStatistics();
//        System.out.println(intSummaryStatistics.getMax());
//        System.out.println(intSummaryStatistics.getAverage());
//        System.out.println(intSummaryStatistics.getCount());
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getSum());
//        System.out.println(intSummaryStatistics.getClass());
    }
}
