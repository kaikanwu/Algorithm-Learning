package leetcode;

import structure.ListNode;

/**
 *  Q:  反转一个单链表。
 *
 * @author kaikanwu
 * @date 13/01/2019
 */
public class Q206_ReverseLinkedList {



    /**
     * Time:O(n)
     * Space: O(1)
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        // 当 cur == null 时， pre 就指向反转后链表的头节点
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
