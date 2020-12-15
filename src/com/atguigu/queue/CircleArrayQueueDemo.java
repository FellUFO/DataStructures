package com.atguigu.queue;

/**
 * @ClassName CircleArrayQueue
 * @Description 环形数组队列demo
 * @Author 15725
 * @Data 2020/11/19 13:19
 **/
public class CircleArrayQueueDemo {

}

class CircleArray {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * front变量的含义为指向队列的第一个元素的数组下标
     * front的初始值为0
     */
    private int front;
    /**
     * rear变量的含义为指向队列最后一个元素的后一个位置的数组下标
     * rear初始值为0
     */
    private int rear;
    /**
     * 存放数据
     */
    private int[] arr;

    /**
     * 构造器
     * @param arrMaxSize
     */
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断是否满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }


}

