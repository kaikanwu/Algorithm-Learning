package leetcode;

import java.util.Stack;

/**
 *  Q:  给定两个二叉树，编写一个函数来检验它们是否相同。
 *      如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *  A:  1. 递归 2. 迭代
 *      解法可以参考 Q101 Symmetric Tree
 *
 *  @author kaikanwu
 * @date 12/01/2019
 */
public class Q100_SameTree {

    public class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

    }

    /**
     *  方法一： 迭代的方法
     *  Time: O(n), Space: O(1)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 迭代方法, 一定要注意写好迭代终止条件
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }


    /**
     *  方法二： 递归
     *  Time: O(n), Space: O(n)
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.empty()) {
            TreeNode s = stack.pop();
            TreeNode t = stack.pop();
            if (s == null && t == null) {
                continue;
            }
            if (s == null || t == null) {
                return false;
            }
            if (s.val != t.val) {
                return false;
            }

            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }
        return true;

    }

}
