package pointToOfferII;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 */
public class Q9_CQueue {

    Stack<Integer> stack1, stack2;

    public Q9_CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        // 要先判断 stack2 是否为空，不然会把队尾的值加入到 stack2 中
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            if (stack2.isEmpty()) {
                return -1;
            }
        }
        return stack2.pop();
    }
}
