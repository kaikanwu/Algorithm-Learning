package pointToOffer;

import java.util.Stack;

/**
 *  Q: 栈的压入、弹出序列
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否是该栈的弹出序列。
 *
 *  A：
 *
 *  思路：使用一个栈来模拟压入弹出操作
 *  如何判断：
 *  1. 如果下一个弹出的数字刚好是栈顶元素，那么直接弹出。
 *  2. 如果下一个弹出的数字不在栈顶，则把压入栈序列中还没有入栈的数字压入辅助栈，
 *     直到把下一个需要弹出的数字压入栈顶为止
 *
 *  3. 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列
 *
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P169_StackPushPopOrder {



    public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {

        if (pushOrder == null || popOrder == null) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();

        int n = pushOrder.length;
        for (int pushIndex =0, popIndex = 0; pushIndex < n ; pushIndex++) {
            stack.push(pushOrder[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popOrder[popIndex]) {

                stack.pop();
                popIndex++;

            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {5, 4, 3, 2, 1};
        int[] test = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder(push, pop));
        System.out.println(isPopOrder(push, test));
    }



}
