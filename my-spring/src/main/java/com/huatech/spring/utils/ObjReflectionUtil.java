package com.huatech.spring.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.huatech.spring.annotation.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @description: 对象反射的公共方法
 * @author: SongXY
 * @create: 2021-08-15 17:16
 **/
@Slf4j
public class ObjReflectionUtil {
    /**
     * 创建类的实例
     * @param ogj
     * @return
     * @throws ClassNotFoundException
     */
    public static Object newOgj(Class<?> ogj) throws ClassNotFoundException {
        //获取包路径
        String name = ogj.getName();
        //获取对象的class
        Class<?> calzz = Class.forName(name);
        log.info("newOgj: "+calzz);
        Object o = null;
        try {
            o = calzz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o;
    }


    /**
     * 获得类中属性相关的方法
     * getField(String name)	获得某个公有的属性对象
     * getFields()	获得所有公有的属性对象
     * getDeclaredField(String name)	获得某个属性对象
     * getDeclaredFields()	获得所有属性对象
     */

    public static Field[] getFields(Class<?> ogj) throws ClassNotFoundException {
        String name = ogj.getName();
        Class<?> calzz = Class.forName(name);
        Field[] declaredFields = calzz.getDeclaredFields();
        return declaredFields;
    }

    /**
     * getMethod(String name, Class...<?> parameterTypes)	获得该类某个公有的方法
     * getMethods()	获得该类所有公有的方法
     * getDeclaredMethod(String name, Class...<?> parameterTypes)	获得该类某个方法
     * getDeclaredMethods()	获得该类所有方法
     */

    public static Method[] getMethods(Class<?> ogj) throws ClassNotFoundException {
        String name = ogj.getName();
        Class<?> calzz = Class.forName(name);
        Method[] declaredMethods = calzz.getDeclaredMethods();
        return declaredMethods;
    }

    /**
     * getAnnotation(Class<A> annotationClass)	返回该类中与参数类型匹配的公有注解对象
     * getAnnotations()	返回该类所有的公有注解对象
     * getDeclaredAnnotation(Class<A> annotationClass)	返回该类中与参数类型匹配的所有注解对象
     * getDeclaredAnnotations()	返回该类所有的注解对象
     * 获取类上注解
     */
    public static Object getClassAnnotation(Class<?> ogj) throws ClassNotFoundException {
        String name = ogj.getName();
        Class<?> calzz = Class.forName(name);
        ClassAnnotation classAnnotation = calzz.getAnnotation(ClassAnnotation.class);
        if (Objects.nonNull(classAnnotation)) {
            return classAnnotation;
        }
        return null;
    }

    /**
     * 获取标MethodAnnotation注解的方法
     */
    public static List<Method> getMethod(Class<?> ogj) throws ClassNotFoundException {
        Method[] methods = getMethods(ogj);
        ArrayList<Method> list = new ArrayList<>();
        for (Method method : methods) {
            MethodAnnotation methodAnnotation = method.getAnnotation(MethodAnnotation.class);
            //方法上没有标注 MethodAnnotation 就返回null  spring3.0书中所说
            if (Objects.nonNull(methodAnnotation)) {
                list.add(method);
            }
        }
        return list;
    }
}
