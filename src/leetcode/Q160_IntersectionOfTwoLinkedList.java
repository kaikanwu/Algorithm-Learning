package leetcode;

import structure.ListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * @author kaikanwu
 * @date 20/02/2020
 */
public class Q160_IntersectionOfTwoLinkedList {


    /**
     * Time:O(m+n), Space: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;

        // p q 在两条链表互相跳转
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }

}
