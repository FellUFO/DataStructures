package com.atguigu.queue;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * @ClassName ArrayQueueDemo
 * @Description 数组模拟队列演示
 * @Author 15725
 * @Data 2020/11/19 11:21
 **/
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 推出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    //取出数据
                    try {
                        int result = queue.getQueue();
                        System.out.printf("取出数据为%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头
                    try {
                        int head = queue.headQueue();
                        System.out.printf("队列头的数据为%d\n", head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    //退出程序
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }




}
/**
 * 使用数组队列模拟-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数组用于存放数据。模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     * @param arrMaxSize
     */
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头部，分析出front是指向队列头的前一个位置
        front = -1;
        //指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
        rear = -1;
    }

    /**
     * 判断队列是否满
     * @return
     */
    public boolean iSFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断的队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param data
     */
    public void addQueue(int data) {
        //首先判断队列是否已满
        if (iSFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        //让rear后移
        rear++;
        arr[rear] = data;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("队列为空，无法取出数据！");
        }
        //front后移
        front++;
        return arr[front];
    }

    /**
     * 显示当前队列的所以数据
     */
    public void showQueue() {
        //遍历
        //判断
        if (isEmpty()) {
            System.out.println("队列为空，无法遍历！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据
     * @return
     */
    public int headQueue() {
        //先判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front + 1];
    }
}
