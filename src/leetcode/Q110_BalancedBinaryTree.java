package leetcode;


import leetcode.structure.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Q110_BalancedBinaryTree {


    /**
     * Time:O(n * log(n))
     * Space:O(n)
     */
    public boolean isBalancedTopDown(TreeNode root){
        return Math.abs(getHeight(root.left)- getHeight(root.right)) <= 1 &&
                isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public boolean isBalancedBottomUp(TreeNode root) {

        return getHeightAndCheck(root) != -1;
    }

    int getHeightAndCheck(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeightAndCheck(root.left);
        if (left == -1) {
            return -1;
        }

        int right = getHeightAndCheck(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

}