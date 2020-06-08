package leetcode;

/**
 * @author kaikanwu
 * created on 6/8/2020
 */
public class Q142_LinkedListCycle_II {

    class ListNode{

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }


    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public ListNode detectCycle(ListNode head) {

        ListNode fast;
        ListNode slow;
        fast = head;
        slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;


    }




}
