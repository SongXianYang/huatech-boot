package com.huatech;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-09-20 21:34
 **/
public class MyAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
//        boolean b = atomicInteger.compareAndSet(1, 90);
//        System.out.println("atomicInteger = " + b+atomicInteger.get());
//        System.out.println("atomicInteger = " + atomicInteger.compareAndSet(1, 90));

        new Thread(()->{
            atomicInteger.compareAndSet(1, 3);
            System.out.println(atomicInteger.get());
        },"A").start();

        new Thread(()->{
            atomicInteger.compareAndSet(3, 6);
            System.out.println(atomicInteger.get());
        },"B").start();

        new Thread(()->{
            atomicInteger.compareAndSet(6, 1);
            System.out.println(atomicInteger.get());
        },"C").start();
    }
}

/**
 * @author 解决ABA问题
 */
class ABA {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(1, 1);
        System.out.println(integerAtomicStampedReference.getStamp());
        integerAtomicStampedReference.compareAndSet(1, 22, 1, integerAtomicStampedReference.getStamp() + 1);
        System.out.println(integerAtomicStampedReference.getReference());
        System.out.println(integerAtomicStampedReference.getStamp());

    }
}
