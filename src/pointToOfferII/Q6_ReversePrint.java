package pointToOfferII;

import leetcode.structure.ListNode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Q6_ReversePrint {

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static int[] reversePrint2(ListNode head) {

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        int[] result = new int[length];
//        for (int i = length - 1; i >= 0; i--) {
//            result[i] = head.val;
//        }
        while (head != null) {
            result[length - 1] = head.val;
            length--;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        System.out.println(Arrays.toString(reversePrint2(head)));
    }
}
