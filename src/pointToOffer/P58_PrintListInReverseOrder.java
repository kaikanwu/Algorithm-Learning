package pointToOffer;

import structure.ListNode;

import java.util.Stack;

/**
 * Q:从尾到头打印链表
 */
public class P58_PrintListInReverseOrder {


    /**
     * 方法一： 使用递归的方法
     *
     * 递归在本质上就是一个栈结构。
     * 这里使用递归有一个问题：当链表的很长的时候，会导致调用递归的层级很深，从而有可能导致函数调用
     * 栈溢出。
     *
     * 递归一般有两个问题：
     *  1.性能问题（每一次函数调用都需要不断的开辟 栈内存）
     *  2.调用栈溢出问题（由于每个线程拥有的栈内存是有限的，当调用的层级太多，会超出栈的容量）
     *
     * 所以第二种方法基于循环实现的代码的鲁棒性更好些。
     * 递归和栈的内容详见：2.4.1
     *
     * @param node
     */
    public static void printReversinglyRecursively(ListNode<Integer> node) {

        if (node == null) {
            return;
        }
        else {
            printReversinglyRecursively(node.next);
            System.out.println(node.val);
        }
    }


    /**
     * 方法二： 不使用递归。 将链表的值一个个压入栈之中，然后遍历取出栈。
     *
     * 栈的一些方法复习：
     *  - pop() 移除栈顶元素并返回该值。
     *  - peek() 取出栈顶元素但是不移除该元素。
     *  - push() 向栈顶添加元素
     *  - isEmpty(） 判断栈是否为空
     *
     * @param node
     */
    public static void printReversinglyIteratively(ListNode<Integer> node) {
        Stack<Integer> stack = new Stack<>();

        for (ListNode<Integer> temp = node; temp != null; temp = temp.next) {
            stack.add(temp.val);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }


    }

    /**
     * 打印链表
     * @param head
     */
    public static void print(ListNode<Integer> head) {

        if (head == null) {
            return;
        }
        while (head != null) {

            System.out.println(head.val);
            head = head.next;
        }
    }



    public static void main(String[] args) {

        ListNode<Integer> head = new ListNode<Integer>(1);
        head.next = new ListNode<Integer>(2);
        head.next.next = new ListNode<Integer>(3);
        head.next.next.next = new ListNode<>(5);

        printReversinglyRecursively(head);
        System.out.println("========");

        printReversinglyIteratively(head);


        System.out.println("========");

        print(head);
    }

}
