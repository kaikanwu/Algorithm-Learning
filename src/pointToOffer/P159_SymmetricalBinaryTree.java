package pointToOffer;

import structure.TreeNode;

/**
 *  Q: 对称的二叉树
 *  请实现一个函数，判断一颗二叉树是否是对称的。
 *  如果一颗二叉树和它的镜像一样，那么它是对称的。
 *
 *  A:
 *  我们发现，我们可以通过比较二叉树的前序遍历序列（根左右）
 *  和对称前序遍历（根右左）序列来判断二叉树是不是对称的。
 *
 * @author kaikanwu
 * @date 11/11/2018
 */
public class P159_SymmetricalBinaryTree {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }

        return isSymmetrical(t1.left, t2.right) && isSymmetrical(t1.right, t2.left);
    }


}
