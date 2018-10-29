package pointToOffer;

import structure.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  7. 重建二叉树
 *
 *  题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 *  假设输的前序遍历和中序遍历的结果中不含重复的数字。
 *
 *  解题思路：
 *  1. 叉树中，需要前序+中序，或者中序+后序 才能重建一个二叉树。 前序+后序 无法重建。
 *
 *
 * @author kaikanwu
 * @date 25/10/2018
 */
public class P62_ConstructBinaryTree {


    /**
     *  方法 1
     * @param preOrder 前序遍历的结果
     * @param inOrder 中序遍历的结果
     * @return
     */
    public static TreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || preOrder.length != inOrder.length) {
            return  null;
        }

        return constructCore(preOrder, 0, inOrder, 0, preOrder.length);
    }


    /**
     *  constructCore
     * @param preOrder
     * @param preOrderStart
     * @param inOrder
     * @param inOrderStart
     * @param length preOrder 的长度
     * @return
     */
    public static TreeNode constructCore(int[] preOrder, int preOrderStart, int[] inOrder, int inOrderStart, int length) {

        if (length == 0) {
            return null;
        }

        //这部分是为了找到前序遍历的一个数，也就是根节点，在中序遍历的位置， inOrderIndex
        //根据题意，由于没有重复的数，所以当 if (inOrder[i] == preOrder[preOrderStart]) 时，就可以找到
        int inOrderIndex = -1;
        for (int i = inOrderStart; i < inOrderStart + length; i++) {
            if (inOrder[i] == preOrder[preOrderStart]) {
                inOrderIndex = i;
                break;
            }
        }

        //左子树的长度
        int leftLength = inOrderIndex - inOrderStart;

        //根节点 - 前序遍历的第一个数
        TreeNode node = new TreeNode(preOrder[preOrderStart]);
        //递归
        node.left = constructCore(preOrder, preOrderStart + 1, inOrder, inOrderStart, leftLength);
        node.right = constructCore(preOrder, preOrderStart + leftLength + 1, inOrder, inOrderIndex + 1, length - leftLength - 1);
        return node;
    }


    /**
     * FOR TEST!
     * @param args
     */
    public static void main(String[] args) {

        //          1
        //         /  \
        //        2    3
        //       / \
        //      4   5

        int[] pre = {1, 2, 4, 5, 3};
        int[] in = {4, 2, 5, 1, 3};

        TreeNode root = construct(pre, in);


        List<Integer> preOrder = P60_TraverseOfBinaryTree.preOrderIteratively(root);
        List<Integer> inOrder = P60_TraverseOfBinaryTree.inOrderIteratively(root);
        List<Integer> postOrder = P60_TraverseOfBinaryTree.postOrderIteratively(root);

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
    }

}
