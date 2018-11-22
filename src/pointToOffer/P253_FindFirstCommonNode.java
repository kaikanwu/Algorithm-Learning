package pointToOffer;

import structure.ListNode;

/**
 *  Q: 输入两个链表，找出它们的第一个公共节点。
 *
 *  A：
 *  1. 暴力求解：遍历第一个链表的一个节点时，遍历第二个链表的每个节点。 时间复杂度 O（m*n）
 *  2. 分别存入两个栈，求栈中最深的相同节点。 时间复杂度 O(m+n), SC: O(m+n)
 *  3. 倡廉表先行 |n-m| 步， 转化为等长链表。 O(m + n) , O(1)
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P253_FindFirstCommonNode {

    /**
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {

        ListNode l1 = head1;
        ListNode l2 = head2;

        while (l1 != l2) {
            l1 = (l1 == null)? head1: l1.next;
            l2 = (l2 == null) ? head2 : l2.next;
        }

        return l1;


    }


}
