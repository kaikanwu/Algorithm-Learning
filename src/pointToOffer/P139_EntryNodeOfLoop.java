package pointToOffer;

import structure.ListNode;

/**
 *  Q: 链表中环的入口节点
 *  如果一个链表中包含环，如何找出环的入口节点？
 *
 *
 *  A：
 *  这个问题需要考虑两个部分：
 *  1. 所给的链表是否包含环？
 *  - 设置两个指针，一个指针一次移动一个节点，另一个一次移动两个节点。
 *    如果走的快的指针追上了走的慢的指针，说明这个链表包含环。
 *
 *
 *  2. 如何找到环的入口节点？
 * @author kaikanwu
 * @date 02/11/2018
 */
public class P139_EntryNodeOfLoop {

    /**
     *
     * @param head 根据题意，这里输入的链表包含环
     * @return 返回链表中环的入口节点
     */
    public ListNode entryNodeOfLoop(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        // 在两个指针相遇之后，将快指针重新从头开始移动，速度变为每次移动一个节点。
        // 当他们再次相遇时，就是环的入口节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
