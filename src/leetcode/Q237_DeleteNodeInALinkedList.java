package leetcode;

import structure.ListNode;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 * 示例 1:
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 说明：
 *
 *  链表至少包含两个节点。
 *  链表中所有节点的值都是唯一的。
 *  给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 *  不要从你的函数中返回任何结果。
 * @author kaikanwu
 * @date 16/02/2020
 */
public class Q237_DeleteNodeInALinkedList {

    /**
     * 这里的输入是指要删除节点的指针
     * 1. 如果可以获取首节点，我们就用要删除节点的前一个节点来指向要删除节点的下一个节点。
     * 2. 在这种没法获取首节点的情况下
     *     2.1 我们先用 p 下一个节点的 val 覆盖 p 的 val
     *     2.2 将 p.next 指向 p.next.next
     *  （相当于用 p 替换了 p.next，从另一个角度达成了删除的效果）
     *
     *
     * Time: O(1), Space: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
