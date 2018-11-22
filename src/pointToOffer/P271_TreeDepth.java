package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 二叉树的深度
 *  输入一棵二叉树的根节点，求该数的深度。从根节点到叶节点一次经过的节点（含根、叶节点）
 *  形成树的一条路径，最长路径为树的深度。
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P271_TreeDepth {

    /**
     * 使用递归的方法，最简单
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left>right? (left+1): right+1;
    }
}
