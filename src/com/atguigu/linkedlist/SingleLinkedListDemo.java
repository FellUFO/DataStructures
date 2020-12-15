package com.atguigu.linkedlist;

import java.awt.*;
import java.util.Stack;

/**
 * @ClassName SingleLinkedList
 * @Description 单链表
 * @Author 15725
 * @Data 2020/11/24 13:28
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero_1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero_2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero_3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero_4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(hero_1);
//        singleLinkedList.add(hero_4);
//        singleLinkedList.add(hero_2);
//        singleLinkedList.add(hero_3);
        //加入

        singleLinkedList.addByOrder(hero_1);
        singleLinkedList.addByOrder(hero_4);
        singleLinkedList.addByOrder(hero_2);
        singleLinkedList.addByOrder(hero_3);
        //遍历显示
        singleLinkedList.list();
//        System.out.println("==================");
//        HeroNode hero_5 = new HeroNode(4, "零充", "豹子头");
//        singleLinkedList.update(hero_5);
//        singleLinkedList.list();
    }

    /**
     * 获取到单链表的节点的个数（如果带头节点的链表，需求不统计头节点）
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if(head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量,这里我们没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            length ++;
            //进行遍历
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第K个节点
     * 1.编写一个方法，接收一个index
     * 2.index表示是倒数第index个节点
     * 3.先把链表从头到尾遍历，得到链表总的长度(getLength)
     * 4.得到size后，我们从链表的第一个开始遍历（size-index）个，就可以得到
     * 5.如果找到了，则返回该节点，否则返回bull
     * @param head 头节点
     * @param index 表示是倒数第index个节点
     * @return 返回的节点
     */
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //首先判断链表是否为空
        if (head.next == null) {
            return null;
        }
        //第一个遍历得到链表的长度（节点个数）
        int size = getLength(head);
        //第二次遍历size-index位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义给辅助变量，for循环定位倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 将单链表进行反转
     * @param head 头节点
     */
    public static void reverseList(HeroNode head) {
        //如何当前链表为空，或者只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助指针，帮我们遍历原来的链表
        HeroNode cur = head.next;
        //指向当前节点【cur】的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            //先暂时保存当前节点的下一个节点，因为后面需要使用
            next = cur.next;
            //将cur的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            //将cur连接到新的链表上
            reverseHead.next = cur;
            //将cur后移
            cur = next;
        }
        //将head.next指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 从头到尾打印单链表
     * 思路:利用栈这个数据结构，将各个节点压入栈中，
     * 然后利用栈的先今后出的特点，便实现了逆序打印的效果
     * @param head 头节点
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null) {
            stack.push(cur);
            //使cur后移
            cur = cur.next;
        }
        //将栈中的节点进行打印，pop出栈
        while (stack.size() > 0 ) {
            //stack的特点是先进后出
            System.out.println(stack.pop());
        }
    }

    //练习：
    //合并两个有序的单链表，合并之后的链表依然有序
    //思路：创建一个新链表，
    public static HeroNode merge(HeroNode firstHead, HeroNode secondHead) {
        //current结点指向新链表
        HeroNode cur = null;
        //合并后的链表的头节点
        HeroNode head = null;
        if (null == firstHead) {
            return secondHead;
        } else if (null == secondHead) {
            return firstHead;
        } else {
            //确定头节点
            if (firstHead.no < secondHead.no) {
                head = firstHead;
                cur = firstHead;
                firstHead = firstHead.next;
            } else {
                head = secondHead;
                cur = secondHead;
                secondHead = secondHead.next;
            }
            while (firstHead != null && secondHead != null) {
                if (firstHead.no < secondHead.no) {
                    cur.next = firstHead;
                    //新链表中，current指针的下一个节点对应较小的哪个数据
                    cur = cur.next;
                    firstHead = firstHead.next;
                } else {
                    cur.next = secondHead;
                    cur = cur.next;
                    secondHead = secondHead.next;
                }
            }
            //合并剩余的元素
            if (firstHead != null) {
                //说明链表2已遍历完
                cur.next = firstHead;
            }
            if (secondHead != null) {
                //说明链表1已遍历完
                cur.next = secondHead;
            }
            return head;
        }
    }
}

/**
 * 定义SingleLinkedList 管理我们的英雄
 */
class SingleLinkedList {
    /**
     * 先初始化一个头节点，头节点不要动，不存放具体的数据
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路，当不考虑编号顺序时
     * 1.找到当前链表的最后节点
     * 2，将最后的这个节点的next指向新的节点
     * @param heroNode
     */
    public void add(HeroNode heroNode) {

        //因为head节点不能动，以此我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if(temp.next == null) {
                break;
            }
            //如果没有找到最后，则将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next，指向新的节点
        temp.next = heroNode;
    }

    /**
     * 修改节点的信息，根据编号来修改
     * 1根据node的编号【no】来修改
     * @param node
     */
    public void update(HeroNode node) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点【根据no】
        //定义一个辅助变量
        HeroNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;  //已经遍历完链表
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag，判断是否找到需要修改的节点
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            //未找到所需要修改的节点
            System.out.printf("没有找到 编号 %d 的节点,不能修改\n", node.no);
        }
    }




    /**
     * 根据编号来添加
     * @param node
     */
    public void addByOrder(HeroNode node) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        //因为单链表，因为我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        //flag标志添加的编号是否存在，默认为false
        boolean flag= false;
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > head.no) {
                //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == node.no) {
                //说明希望添加的node的编号已经存在
                flag = true;
                break;
            }
            //后移【遍历当前的链表】
            temp = temp.next;
        }
        //判断flag的值
        if (flag) {
            //不能添加，说明编号已存在
            System.out.printf("准备插入的英雄的编号%d 已经存在，不能加入\n", node.no);
        } else {
            //插入到链表中。temp的后面
            node.next = temp.next;
            temp.next = node ;
        }
    }

    /**
     * 显示链表【遍历】
     * tips: 1.头节点不存在数据，只是起到指示第一个节点的位置的用
     */
    public void list() {
        //判断链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，我们需要一个辅助变量temp
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //要将temp后移，不然为死循环
            temp = temp.next;
        }
    }

    /**
     * 思路：
     * 1.head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
     * 2.说明我们在比较时，是temp.next.no和需要删除的节点的no比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在！" + no);
        }
    }

}

/**
 * 定义HeroNode，每个HeroNode，对象都是一个节点
 */
class HeroNode {
    public  int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;
    /**
     * 构造器
     */
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


