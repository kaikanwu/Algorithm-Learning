package leetcode;

import structure.ListNode;

import java.util.Stack;

/**
 * Q:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author kaikanwu
 * @date 11/02/2020
 */
public class Q203_RemoveLinkedListElements {

    /**
     * 方法一：使用额外的 stack 来存储会保留的节点
     * Time:O(n), Space: O(n)
     */
    public ListNode removeElements1(ListNode head, int val) {

        Stack<ListNode> stack = new Stack<>();

        // 将与 val 值不同的节点，保存啊在 stack 中
        while (head != null) {
            if (head.val != val) {
                stack.push(head);
            }
            head = head.next;
        }

        // peek(): return the top element without remove it
        // pop(): remove the top element, and return it
        while (!stack.isEmpty()) {
            // 注意这里第一次循环时的 head 是 null
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;


    }

    /**
     *
     * Time: O(n), Space: O(1)
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode notEqual = dummy;

        while (notEqual.next != null) {
            if (notEqual.next.val == val) {
                notEqual.next = notEqual.next.next;
            } else {
                notEqual = notEqual.next;
            }
        }
        return dummy.next;
    }

}
