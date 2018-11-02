package pointToOffer;

import structure.ListNode;

/**
 *  Q: 链表中倒数第K个节点
 *  输入一个链表，输出该链表中倒数第K个节点
 *
 *  例如一个链表有 6 个节点，从头节点开始，它们的值依次是1，2，3，4，5，6。
 *  那么这个链表的倒数第 3 个节点就是值为 4 的节点。
 *
 *  A：
 *  先让快指针移动 k 个节点。此时链表剩下N-K个节点，
 *  这时候让慢指针开始从头结点移动，
 *  当快指针走到尾节点时，慢指针移动了N-K个节点，也就是倒数第 K 个节点。
 *
 * @author kaikanwu
 * @date 02/11/2018
 */
public class P134_FindKThToTail {

    public ListNode findKThToTail(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        // 先让快指针移动 k 个节点。
        ListNode fast = head;
        while (fast != null && k-- > 0) {
            fast = fast.next;
        }

        if (k > 0) {
            return null;
        }

        ListNode slow = head;
        //直到快指针为空，也就是快指针走到了尾节点
        //这时候 慢指针 就是倒数第 K 个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
