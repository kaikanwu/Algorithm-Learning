package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 输入一棵二叉搜索树，将该 BST 转化成为一个排序的双向链表。
 *  要求不能创建任何新的节点，只能调整树中节点指针的方向。
 *
 *  A:
 *  对于一棵二叉搜索树，由于它的特性，对它的中序遍历就是按照从小到大遍历每个节点。
 *
 *
 * @author kaikanwu
 * @date 13/11/2018
 */
public class P191_ConvertBST {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;

        if (pre != null) {

            pre.right = node;
        }
        pre = node;

        if (head == null) {
            head = node;
        }
        inOrder(node.right);


    }

}
