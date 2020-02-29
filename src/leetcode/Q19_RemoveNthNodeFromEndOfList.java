package leetcode;

import structure.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author kaikanwu
 * @date 29/02/2020
 */
public class Q19_RemoveNthNodeFromEndOfList {


    /**
     * Time: O(m),Space:O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        // j 先移动 n 步
        int count = 0;
        while (count < n) {
            j = j.next;
            count++;
        }

        while (j.next != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;

        return dummy.next;


    }


}
