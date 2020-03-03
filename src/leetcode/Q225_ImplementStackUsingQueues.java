package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * Solution:
 * 主要是处理 push 操作，将 queue 的 LILO 特性转变为符合 stack 的 LIFO 特性，所以需要将新加入队列的元素放到队列的首位，即加入元素后，将原有的元素全部 poll 出去，再 add 回队列，这样就能保证最先加入的在最后面。
 * 其他的方法都可以找到 queue 中的对应方法
 *
 *
 * @author kaikanwu
 * @date 01/03/2020
 */
public class Q225_ImplementStackUsingQueues {

    class MyStack {
        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue.add(x);
            int count = queue.size();
            while (count-- > 1) {
                queue.add(queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue.remove();
        }

        /** Get the top element. */
        public int top() {
            return queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
