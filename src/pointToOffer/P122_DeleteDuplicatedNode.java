package pointToOffer;

import structure.ListNode;

/**
 *
 *  Q. 删除链表中重复的节点。
 *  在一个排序的链表中，如何删除重复的节点？
 *  例如， 1->2->2->4->4->5
 *  删除重复的节点 ： 1->5
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P122_DeleteDuplicatedNode {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }


        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && pHead.val == next.val) {
                next = next.next;
            }

            return deleteDuplication(next);
        }
        else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }

    }


}
