package pointToOffer;

import structure.RandomListNode;

/**
 *  Q: 复杂链表的复制
 *  请实现函数 ComplexListNode Clone(ComplexListNode head)
 *  复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *  还有一个 random 指针指向链表中的任意节点或者 null.
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P187_CopyComplexList {

    public RandomListNode Clone(RandomListNode head) {

        if (head == null) {
            return null;
        }

        // 插入新节点
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 简历 random 连接
        cur = head;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //拆分
        cur = head;
        RandomListNode cloneHead = head.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }

        return cloneHead;


    }
}
