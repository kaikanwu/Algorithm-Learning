package pointToOffer;

import structure.ListNode;

/**
 *  Q：反转链表
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后的链表的头节点。
 *
 *  A：
 *
 *
 * @author kaikanwu
 * @date 02/11/2018
 */
public class P142_ReverseList {


    /**
     * 方法一： 递归
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }


    /**
     *  方法二： 迭代（循环）
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode post = head.next;

        while (true) {
            cur.next = pre;
            pre = cur ;
            cur = post;

            if (post != null) {
                post = post.next;
            }
            else {
                return pre;
            }

        }

    }
}
