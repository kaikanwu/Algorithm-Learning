package leetcode;

import structure.ListNode;

import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author kaikanwu
 * @date 23/02/2020
 */
public class Q2_AddTwoNumbers {

    /**
     *  Time: O(max(m,n)), Space: O(max(m,n))
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        // carry 表示进位信息
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
        }
        return dummy.next;
    }



}
