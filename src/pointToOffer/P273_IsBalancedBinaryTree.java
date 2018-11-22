package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 输入一棵二叉树的根节点，判断该数是不是平衡二叉树。
 *  如果某二叉树中任意节点的左、右子树的深度不超过1，那么它就是一棵平衡二叉树。
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P273_IsBalancedBinaryTree {

    private boolean  isBalanced = true;

    public boolean isBalancedSolution(TreeNode root) {
        depth(root);
        return isBalanced;
    }


    private int depth(TreeNode root) {

        // 依旧要注意，每个递归方法必须要有终止条件
        if (root == null || !isBalanced) {
            return  0;
        }
        // 递归语句
        int left = depth(root.left);
        int right = depth(root.right);
        // 验证平衡二叉树的条件
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        // 返回这颗树的深度
        return 1 + Math.max(left, right);



    }
}
