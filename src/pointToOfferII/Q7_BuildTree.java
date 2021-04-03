package pointToOfferII;

import leetcode.structure.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出前序遍历 preorder = [3,9,20,15,7]，中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class Q7_BuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }

        return build(preorder, 0, inorder, 0, preorder.length);

    }

    public TreeNode build(int[] preorder, int preorderStart, int[] inorder, int inorderStart, int length) {

        if (length == 0) {
            return null;
        }

        int inorderIndex = -1;
        for (int i = inorderStart; i < inorderStart + length; i++) {
            if (inorder[i] == preorder[preorderStart]) {
                inorderIndex = i;
                break;
            }
        }
        int leftTreeLength = inorderIndex - inorderStart;

        TreeNode node = new TreeNode(preorder[preorderStart]);

        node.left = build(preorder, preorderStart + 1, inorder, inorderStart, leftTreeLength);
        node.right = build(preorder, preorderStart + leftTreeLength + 1, inorder, inorderIndex + 1, length - leftTreeLength - 1);
        return node;
    }

}
