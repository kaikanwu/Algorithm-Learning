package pointToOffer;

import java.util.Stack;

/**
 * Q:   用两个栈实现一个队列。
 *      队列声明如下，请实现它的两个函数 appendTail, deleteHead。即分别在队列尾部插入节点，
 *      和在队列头部删除节点的功能。
 *
 *  A：
 *      1. 栈 Stack, FILO; 队列 Queue， FIFO
 *      2. push 压入栈， pop 删除头部元素并返回
 *
 *
 *
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P68_QueueWithTwoStacks {


    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();


    public void push(int node) {
        stack1.push(node);
    }


    public int pop()throws Exception {

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("Queue is empty");

        }

        return stack2.pop();

    }


}


