package leetcode;


import leetcode.structure.ListNode;

/**
 * Q:  反转一个单链表。
 * 举例：     5->4->3->2->1->null
 * 反转后：   1->2->3->4->5->null
 *
 * @author kaikanwu
 * created on 13/01/2019
 */
public class Q206_ReverseLinkedList {

    /**
     * Time:O(n)
     * Space: O(1)
     */
    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 当 cur == null 时， pre 就指向反转后链表的头节点
        return pre;
    }

}
