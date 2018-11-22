package pointToOffer;

import structure.TreeNode;

/**
 * Q: 树中两个节点的最低公共祖先
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P326_LowestCommonAncestor {

    /**
     * 对于BST
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {

            return root;
        }
        if (root.val > p.val && root.val > q.val) {

            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {

            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }


    /**
     * 对于普通的二叉树
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {

            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
