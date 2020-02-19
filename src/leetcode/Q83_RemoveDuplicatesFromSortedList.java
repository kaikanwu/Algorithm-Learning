package leetcode;

import structure.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * Solution: 使用两个游标
 *
 * @author kaikanwu
 * @date 19/02/2020
 */
public class Q83_RemoveDuplicatesFromSortedList {


    /**
     * Time:O(n) Space:O(1)
     */
    public ListNode removeDuplicates(ListNode head) {

        // 处理空链表的情况
        if (head == null) {
            return null;
        }

        ListNode p = head;
        ListNode n = head.next;


        // 两个游标始终保持一前一后的情况
        while (n != null) {

            if (p.val == n.val) {
                p.next = n.next;
            }else {
                p = p.next;
            }
            n = n.next;

        }
        return head;

    }



}
