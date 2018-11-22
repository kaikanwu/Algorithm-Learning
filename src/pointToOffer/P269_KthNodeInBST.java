package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 给定一棵二叉搜索树，请找出其中第 K 大的节点。
 *
 *          5
 *        /  \
 *       3    7
 *      / \  / \
 *     2  4 6  8
 *
 *  A: 注意是二叉搜索树，BST。
 *  左子树的值都小于根节点，右子树的值都大于根节点
 *
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P269_KthNodeInBST {

    private TreeNode result;
    private  int count = 0;

    public TreeNode kthNode(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    /**
     * 利用 BST 的中序遍历有序的特点
     * 左根右
     *
     * 所以可以引入一个计数器，每访问一个节点，计数器+1. 当计数器等于k时。
     * 被访问的节点就是该BST的第K大节点。
     * @param root
     * @param k
     */
    private void inOrder(TreeNode root, int k) {

        if (root == null || count >= k) {
            return;
        }

        inOrder(root.left, k);
        count ++;

        if (count == k) {
            result = root;
        }

        inOrder(root.right, k);
    }



}
