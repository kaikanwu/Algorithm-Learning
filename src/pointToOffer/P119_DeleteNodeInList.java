package pointToOffer;

import structure.ListNode;

import java.util.List;

/**
 *  Q: 删除链表的节点
 *  在O（1） 时间内删除链表的节点
 *  给定单项链表的头指针与一个节点指针，定义一个函数在O（1）时间内删除该节点
 *
 *  A：
 *  1. 如果该节点不是尾节点，那么可以直接将下一个节点复制到该节点（覆盖要删除的节点），
 *  然后令该节点指向下下个节点，再删除下一个节点。这样的时间复杂度是O（1）
 *  2.否则，传统删除的做法是：从头遍历链表，找到该节点的前一个节点，然后让前一个节点指向该节点的下一个节点。
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P119_DeleteNodeInList {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {

        if (head == null || tobeDelete == null) {
            return null;
        }
        // 如果要删除的节点不是尾节点
        if (tobeDelete.next != null) {
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        }
        else {
            ListNode cur = head;
            while (cur.next != tobeDelete) {
                cur = cur.next;
            }
            cur.next = null;
        }

        return head;
    }


}
