package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 二叉树的镜像
 *  请完成一个函数，输入一颗二叉树，该函数输出它的镜像。二叉树的节点定义如下：
 *
 *  struct BinaryTreeNode{
 *      int val = 0;
 *      TreeNode left = null;
 *      TreeNode right = null;
 *
 *      public TreeNode(int val){
 *          this.val = val;
 *      }
 *  }
 *
 *
 *  A:
 *  1. 可以先自己画一颗二叉树，然后画出它的镜像。
 *  2. 根据镜像可以总结它的规律。
 *  3. 规律：先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，则交换它的两个子节点。
 *
 *
 *
 * @author kaikanwu
 * @date 11/11/2018
 */
public class P157_MirrorOfBinaryTree {

    public void Mirror(TreeNode root) {

        if (root == null) {
            return;
        }

        swap(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }


}
