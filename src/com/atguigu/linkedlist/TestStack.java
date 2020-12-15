package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @ClassName TestStack
 * @Description TODO
 * @Author 15725
 * @Data 2020/12/1 22:19
 **/
public class TestStack {


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        //出栈
        while (stack.size() > 0) {
            //pop就是将栈顶的数据去除
            System.out.println(stack.pop());
        }

    }

}
