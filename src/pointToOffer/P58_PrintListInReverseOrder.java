package pointToOffer;

import structure.ListNode;

import java.util.Stack;

/**
 * Q:从尾到头打印链表
 */
public class P58_PrintListInReverseOrder {


    /**
     * 方法一： 使用递归的方法
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
