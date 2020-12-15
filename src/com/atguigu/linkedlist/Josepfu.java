package com.atguigu.linkedlist;

/**
 * @ClassName Josepfu
 * @Description TODO
 * @Author 15725
 * @Data 2020/12/3 17:33
 **/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkList linkList = new CircleSingleLinkList();
        linkList.addBoy(25);
        linkList.showBoy();
    }

}

/**
 * 创建环形单向链表
 */
class CircleSingleLinkList {
    /**
     * 创建一个first节点，当前没有编号
     */
    private Boy first = null;

    /**
     * 添加小孩节点，构建一个环形的链表
     * @param nums
     */
    public void addBoy(int nums) {
        //nums校验
        if (nums < 1) {
            System.out.println("nums的值不符合");
            return;
        }
        //辅助变量，帮助构建环形链表
        Boy curBoy = null;
        //使用for循环来创建环形链表
        for (int i = 1; i <= nums; i++) {

            //根据编号创建节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if ( i == 1) {
                first = boy;
                //构成一个环状
                first.setNext(first);
                //让curBoy指向第一个节点
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                //构成环状
                boy.setNext(first);
                curBoy = boy;
            }
        }

    }


    /**
     * 遍历当前环形链表
     */
    public void showBoy() {
        //先判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩的编号：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明遍历完毕
                break;
            }
            //让辅助指针后移，完成遍历
            curBoy = curBoy.getNext();
        }
    }


}

class Boy{
    /**
     * 编号
     */
    private int no;

    /**
     * 指向下一个节点，默认为null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
