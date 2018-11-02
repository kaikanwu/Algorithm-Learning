package pointToOffer;

import structure.ListNode;

/**
 *
 *  Q: 输入两个递增的链表，合并这两个链表并且使新链表中的节点仍然是递增排序的。
 * @author kaikanwu
 * @date 02/11/2018
 */
public class P145_MergeTwoSortedLists {


    public ListNode merge(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if ((int)list1.val <= (int)list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        }else {
            list2.next = merge(list1, list2.next);
            return list2;
        }

    }



}
