package com.atguigu.linkedlist;

/**
 * @ClassName DoubleLinkListDemo
 * @Description TODO
 * @Author 15725
 * @Data 2020/12/2 14:03
 **/
public class DoubleLinkListDemo {





    public static void main(String[] args) {

    }



}

class DoubleNode{
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点，默认为null
     */
    public DoubleNode next;
    /**
     * 指向前一个节点，默认为null
     */
    public DoubleNode pre;

    public DoubleNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}

class DoubleLinkedList{
    /**
     * 先初始化一个头节点，头节点不要动，不存放具体的数据
     */
    private final DoubleNode head = new DoubleNode(0, "", "");

    /**
     * 返回头节点
     */
    public DoubleNode getHead() {
        return head;
    }

    /**
     * 添加一个节点到双向链表最后
     * @param node 被添加节点
     */
    public void add(DoubleNode node) {
        //因为head节点不能动
        DoubleNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后就继续后移遍历
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }


    /**
     * 修改双向链表的节点（和单向链表一样，只是节点类型发生了改变）
     * @param node 修改节点
     */
    public void update(DoubleNode node) {
        //先判断是否为空
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        DoubleNode temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经遍历完该链表
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag来判断是否找到需要修改的节点
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            //没有找到
            System.out.println("没有找到编号为：" + node.no + "的节点，无法修改！");
        }
    }

    /**
     * 从双向链表中删除一个节点
     * 对于双向链表，我们可以直接找到要删除的节点
     * 找到后，自我删除即可
     * @param no 待删除节点编号
     */
    public void delete(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除！");
            return;
        }

        DoubleNode temp = head.next;
        //标志是否找到待删除节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //标志遍历到链表末尾
                break;
            }
            if (temp.no == no) {
                //找到待删除节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag来判断
        if (flag) {
            //找到,进行删除
            temp.pre.next = temp.next;
            //这里需要注意待删除节点是否是最后一个节点
            //不是最后一个节点才执行下一句
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            //未找到
            System.out.println();
        }
    }
}
