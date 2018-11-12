package pointToOffer;

import java.util.Stack;

/**
 *  Q: 包含 min 函数的栈
 *  定义栈的数据结构，请在该类型中实现一个能够得到
 *  栈的最小元素的 min 函数，调用 min、push 及 pop 的时间复杂度都是 O(1)
 *
 *  A:
 *  1. 熟悉栈的基本操作
 *  push(E item) 向栈顶添加元素
 *  pop()   返回栈顶元素，并删除该元素
 *  peek()  返回栈顶元素，但不会删除
 *  isEmpty() 判断栈是否为空
 *
 *  2. 把每次最小的元素（之前最小的元素和新压入栈的元素作比较）存入一个辅助栈之中。
 *  3. 注意这样要求时间复杂度为 O(1) 的题目，大多数都是需要用空间换时间
 *
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P165_StackWithMin {


    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();

        stack.push(3);
        stack.push(4);
        stack.push(5);


        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }






}

class StackWithMin{

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        minStack.push(minStack.isEmpty() ? node : Math.min(minStack.peek(), node));

    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return ;
        }
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        // 注意不要忘记栈为空的情况
        if (minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}
