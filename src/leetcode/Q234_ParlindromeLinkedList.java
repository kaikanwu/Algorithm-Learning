package leetcode;

import java.util.Stack;

/**
 *  Q: 请判断一个链表是否为回文链表。
 *
 *      示例 1:
 *      输入: 1->2
 *      输出: false
 *
 *      示例 2:
 *      输入: 1->2->2->1
 *      输出: true
 *
 *      进阶：
 *      你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 *
 * @author kaikanwu
 * @date 01/04/2019
 */
public class Q234_ParlindromeLinkedList {

    public class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }
    }


    /**
     *  Time: O(n), Space: O(n)
     *  使用堆来处理
     *  堆的几个常用方法：
     *  1. Object push(Object element)      把一个element 压入栈顶
     *  2. object pop()                     移除堆栈顶部的对象，并作为返回值返回该对象
     *  3. object peek()                    查看堆栈顶部的对象，但是不从堆栈中移除它
     *  4. boolean empty()                  查看堆栈是否为空
     *  5. int search()                     返回对象在堆栈中的位置，从 1 开始
     */
    public boolean isPalindrome(ListNode head){

        Stack<Integer> s = new Stack<>();
        // for 循环遍历链表
        for (ListNode p = head; p != null; p = p.next) {
            s.push(p.val);
        }

        for (ListNode p = head; p != null; p = p.next) {
            if (p.val != s.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time:O(n), Space: O(1)
     * 反转一半的链表作比较
     */
    public boolean isPalindromeReverseList(ListNode head) {
        int len = 0;
        for (ListNode p = head; p != null; p = p.next, len++) {

        }

        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < len / 2; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (len % 2 == 1) {
            cur = cur.next;
        }
        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) {
                return false;
            }
        }
        return true;

    }





}
