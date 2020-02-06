package leetcode;

import structure.ListNode;

import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 * 进阶：
 * 你能否不使用额外空间解决此题？
 * <p>
 * A: 使用双指针，一个指针每次移动一个节点，另一个指针每次移动两个节点。
 * 如果存在环，那么这两个指针一定会相遇。
 *
 * @author kaikanwu
 * @date 26/11/2018
 */
public class Q141_LinkedListCycle {


    /**
     * Time:O(n), Space:O(n)
     */
    public boolean hasCycleWithHashSet(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        for (ListNode i = head; i != null; i = head.next) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public boolean hasCycleWithTwoPointer(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    /**
     * Time: O(n), Space:O(1)
     */
    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode l1 = head;
        ListNode l2 = head.next;

        // 什么时候结束循环呢？ 就是指针的下一个节点为null的时候
        while (l1 != null && l2 != null && l2.next != null) {

            if (l1 == l2) {
                return true;
            }
            // l1 移动一个节点， l2 每次移动两个节点
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

}
