package pointToOffer;

import structure.TreeNode;

import java.util.*;

/**
 * 二叉树的遍历：
 * 1. 前序遍历
 * 2. 中序遍历
 * 3. 后续遍历
 * 4. 层级遍历
 *
 * @author kaikanwu
 * @date 25/10/2018
 */
public class P60_TraverseOfBinaryTree {


    /**
     * 方法1.1 - 前序遍历 递归版
     * pre-order 根左右
     *
     * @param node
     * @return
     */
    public static List<Integer> preOrderRecursively(TreeNode<Integer> node) {

        //List 是Collection的一个接口，特点是有序
        List<Integer> list = new ArrayList<>();

        if (node == null) {
            return list;
        }

        list.add(node.val);
        list.addAll(preOrderRecursively(node.left));
        list.addAll(preOrderRecursively(node.right));
        return list;
    }




    /**
     * 方法 2.1 - 中序遍历 递归
     *
     * @param node
     * @return
     */
    public static List<Integer> inOrderRecursively(TreeNode<Integer> node) {

        List<Integer> list = new ArrayList<>();

        if (node == null) {
            return list;
        }

        list.addAll(inOrderRecursively(node.left));
        list.add(node.val);
        list.addAll(inOrderRecursively(node.right));

        return list;
    }

    /**
     * 方法3.1 - 后序遍历 - 递归版
     * 左右根
     *
     * @param node
     * @return
     */
    public static List<Integer> postOrderRecursively(TreeNode<Integer> node) {

        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }

        list.addAll(postOrderRecursively(node.left));
        list.addAll(postOrderRecursively(node.right));
        list.add(node.val);

        return list;
    }


    /**
     * 方法 1.2 - 前序遍历 循环版
     *
     * @return
     */
    public static List<Integer> preOrderIteratively(TreeNode<Integer> node) {

        //stack 栈顶元素永远为curr的父节点
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        List<Integer> list = new LinkedList<>();

        if (node == null) {
            return list;
        }
        //复习栈的常用方法：
        // push() 加入元素到栈顶
        // peek() 取出栈顶元素，但不移除该元素
        // pop()  移除栈顶元素，并返回该元素
        // isEmpty() 判断栈是否为空
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop().right;
            }
        }
        return list;
    }



    /**
     * 方法 2.2 中序遍历 - 循环版
     * 左根右
     * @param node
     * @return
     */
    public static List<Integer> inOrderIteratively(TreeNode<Integer> node) {

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        List<Integer> list = new LinkedList<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                list.add(stack.peek().val);
                cur  = stack.pop().right;
            }
        }
        return list;

    }


    /**
     * 方法 3.2  - 后续遍历 - 循环版
     * @param node
     * @return
     */
    public static List<Integer> postOrderIteratively(TreeNode<Integer> node) {

        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> cur = node;
        TreeNode<Integer> preVisited = null;
        List<Integer> list = new LinkedList<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek().right;
                if (cur != null && cur != preVisited) {
                    stack.push(cur);
                    cur = cur.left;
                }
                else {
                    preVisited = stack.pop();
                    list.add(preVisited.val);
                    cur = null;
                }


            }
        }

        return list;

    }


    /**
     * 宽度优先遍历 - level order (层序)
     *
     *  queue 队列常用方法复习：
     *  1. offer() 插入一个元素
     *  2. pool() 返回第一个元素，并在队列中删除这个元素
     *  3. peek() 返回第一个元素，但是不会删除。
     *
     * @param node
     * @return
     */
    public static List<Integer> levelOrder(TreeNode<Integer> node) {

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        TreeNode<Integer> temp = null;

        if (node == null) {
            return list;
        }
        queue.add(node);

        while (!queue.isEmpty()) {
            temp = queue.poll();
            list.add(temp.val);

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return list;
    }






    /**
     * for test
     *
     * @param args
     */
    public static void main(String[] args) {

        //              1
        //               \
        //                2
        //                /
        //              3
        //
        // pre-order -> 123   in-order ->132    post-order -> 321  level-order -> 123

        //创建二叉树
        TreeNode<Integer> root = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);

        //测试方法一：前序遍历
        List<Integer> preOrderResult1 = preOrderRecursively(root);
        System.out.println(preOrderResult1.toString());

        List<Integer> preOrderResult2 = preOrderIteratively(root);
        System.out.println(preOrderResult2.toString());


    }


}
