package com.huatech.queue;

/**
 * @author Songxianyang
 * @description: 学习队列
 * @create: 2021-12-09 21:34
 **/
public class ArrayQueue {
    /**
     * 数组属性
     */
    int[] array;

    public ArrayQueue(Integer sizeMax) {

        this.sizeMax = sizeMax;
        array = new int[sizeMax];
        read = -1;
        front = -1;
    }

    /**
     * 判断数组为空
     *
     * @param
     * @return
     */
    private Boolean isNull() {
        return read == front;
    }

    /**
     * 数组已满
     * @return
     */
    private Boolean isFull
            () {
      return   read == sizeMax - 1;
    }

    /**
     * 数组最大容量
     */
    private Integer sizeMax;

    /**
     * 属性 输入时：read+1
     */
    private int read;
    /**
     * 属性 输出时：front-1
     */
    private Integer front;


    /**
     * 成员方法 往这个队列中加数剧
     */

    private void addQueue(Integer integer) {
        if (isFull()) {
            throw new RuntimeException("数组已满");
        }
        read++;
        array[read] = integer;
    }

    /**
     * 取数据
     */
    private int getQuery() {
        if (isNull()) {
            throw new RuntimeException("数组为null");
        }
        front++;

        return array[front];

    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        for (int i = 0, size = 10; i < size; i++) {
            arrayQueue.addQueue(i);
            System.out.println(arrayQueue.getQuery());

        }
    }
}
