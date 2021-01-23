package leetcode;


import leetcode.structure.TreeNode;

import java.util.Stack;

/**
 *  Q:  给定一个二叉树，检查它是否是镜像对称的。
 *
 *  A:  1. 递归 2. 迭代
 *
 * @author kaikanwu
 * @date 11/01/2019
 */
public class Q101_SymmetricTree {

    /**
     * 方法一：递归（recursive）
     * Time:O(n), Space:O(n)
     * 注意：这里的Space Complexity 是考虑到最差的情况：这棵树只有最左分支和最右分支
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    /**
     * 方法一的辅助函数
     */
    private boolean isSymmetric(TreeNode l, TreeNode r){
        if (l != null && r != null) {
            return l.val == r.val
                    && isSymmetric(l.left, r.right)
                    && isSymmetric(l.right, r.left);
        }
        else {
            // 必须两边都为空才返回 true
            return l == null && r == null;
        }
    }

    /**
     * 方法二：迭代(iterative)
     * Time:O(n)
     * Space: O(n)
     */
    public boolean isSymmetric2(TreeNode root){

        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        // 在这个循环里主要判断是否会不相等
        while (!stack.isEmpty()) {
            // pop() 会返回栈顶元素，并移除该元素
            // 不要和 peek() 搞混，peek() 只返回，不移除
            TreeNode r = stack.pop();
            TreeNode l = stack.pop();
            if (l == null && r == null) {
                continue;
            }
            if (l == null || r == null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            // 注意顺序，应该是镜像的添加
            // 虽然我们对比的是节点的值，但是这里入栈的必须是节点本身。
            // 因为在接下来的循环中，我们还需要取该节点的左右子节点。
            stack.push(l.left);
            stack.push(r.right);
            stack.push(l.right);
            stack.push(r.left);
        }
        return true;
    }

}
