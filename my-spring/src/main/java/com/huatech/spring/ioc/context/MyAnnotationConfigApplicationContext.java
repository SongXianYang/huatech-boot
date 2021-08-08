package com.huatech.spring.ioc.context;

import com.huatech.spring.ioc.annotation.MyComponent;
import com.huatech.spring.ioc.annotation.MyValue;
import com.huatech.spring.ioc.annotation.MyAutowired;
import com.huatech.spring.ioc.annotation.MyQualifier;
import com.huatech.spring.ioc.definition.BeanDefinition;
import com.huatech.spring.ioc.util.MyTools;
import lombok.extern.slf4j.Slf4j;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-08-07 18:08
 **/
@Slf4j
public class MyAnnotationConfigApplicationContext {

    private Map<String, Object> iocMap = new HashMap<>();

    public MyAnnotationConfigApplicationContext(String basePackages) {
        //获取包下面的所有类
        Set<Class<?>> classes = MyTools.getClasses(basePackages);
        Iterator<BeanDefinition> iterator = findByMyComponentDefinition(classes).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------");
        creteObj(findByMyComponentDefinition(classes));
    }

    public Object getBean(String beanName) {
        return iocMap.get(beanName);
    }

    /**
     * 4、遍历 Set 集合，通过反射机制创建对象，同时检测属
     * 性有没有添加 @Value 注解，如果有还需要给属性赋
     * 值，再将这些动态创建的对象以 k-v 的形式存入缓存
     * 区。
     */
    private void creteObj(Set<BeanDefinition> beanDefinitions) {
        beanDefinitions.forEach(beanDefinition -> {
            Class clazz = beanDefinition.getBeanClazz();
            String beanName = beanDefinition.getBeanName();
            //获取对象中的属性数组
            Field[] declaredFields = clazz.getDeclaredFields();
            Object object = null;
            try {
                object = clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            for (Field declaredField : declaredFields) {
                //获取带有MyValue的属性
                MyValue valueAnnotation = declaredField.getAnnotation(MyValue.class);
                if (Objects.nonNull(valueAnnotation)) {
                    //获取注解中的值
                    String value = valueAnnotation.value();
                    //属性方法setXxx
                    String fieldName = "set" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1);
                    try {
                        //创建方法
                        Method method = clazz.getMethod(fieldName, declaredField.getType());
//                        log.info("method: "+method);
//                        log.info("获取属性类型: "+declaredField.getType().getName());
                        Object var = null;
                        switch (declaredField.getType().getName()) {
                            case "java.lang.Integer":
                                var = Integer.parseInt(value);
                                break;
                            case "java.lang.String":
                                var = value;
                                break;
                            case "java.lang.Float":
                                var = Float.parseFloat(value);
                                break;
                        }
                        method.invoke(object, var);

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

                /**
                 * 自动装载
                 */
                //判断属性上是否MyAutowired
                MyAutowired myAutowired = declaredField.getAnnotation(MyAutowired.class);
                if (Objects.nonNull(myAutowired)) {
                    //判断属性上是否MyQualifier
                    MyQualifier myQualifier = declaredField.getAnnotation(MyQualifier.class);
                    if (Objects.nonNull(myQualifier)) {
                        String qualifierValue = myQualifier.value();

                        Object bean = getBean(qualifierValue);
                        //获取获取带有MyAutowired属性set
                        String methodName = "set" + declaredField.getName().substring(0, 1).toUpperCase() + declaredField.getName().substring(1);
                        try {
                            Method methodAutowired = clazz.getMethod(methodName, declaredField.getType());
                            methodAutowired.invoke(object, bean);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

                }
                //获取
                //获取属性名称declaredField.getName()
//                log.info(declaredField.getName());
//                System.out.println(declaredField.getName());
            }
            iocMap.put(beanName, object);
        });

    }

    /**
     * 获取标有MyComponent这个注解的类      装进Set<BeanDefinition>
     * <p>
     * 3、遍历这些类，找出添加了 @Component 注解的类，
     * 获取它的 Class 和对应的 beanName，封装成一个
     * BeanDefinition，存入集合 Set，这个机会就是 IoC 自动
     * 装载的原材料。
     */
    private Set<BeanDefinition> findByMyComponentDefinition(Set<Class<?>> classes) {
        //定义一个Set<BeanDefinition>
        Set<BeanDefinition> beanDefinitions = new HashSet<>();
        //遍历所有类
        for (Class<?> clazz : classes) {
            //获取 MyComponent 注解的类
            MyComponent component = clazz.getAnnotation(MyComponent.class);
            if (Objects.nonNull(component)) {
                //获取注解里的值
                String beanName = component.value();

                //注解里的值有可能是null
                if (StringUtils.isEmpty(beanName)) {
                    //获取包名称
                    String packageName = clazz.getPackage().getName() + ".";
                    //获取全类名
                    String allClassName = clazz.getName();
                    //去除
                    String className = allClassName.replaceAll(packageName, "");

                    beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                }
                //装进去
                beanDefinitions.add(new BeanDefinition(clazz, beanName));
            }
        }
        return beanDefinitions;
    }
}
