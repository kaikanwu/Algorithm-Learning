package pointToOffer;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.IdentNode;
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
     * @param preOrder
     * @param inOrder
     * @return
     */
    public static TreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || preOrder.length != inOrder.length) {
            return  null;
        }

        return constructCore(preOrder, 0, inOrder, 0, preOrder.length);
    }


    public static TreeNode constructCore(int[] preOrder, int preOrderStart, int[] inOrder, int inOrderStart, int length) {

        if (length == 0) {
            return null;
        }

        int inOrderIndex = -1;
        for (int i = inOrderStart; i < inOrderStart + length; i++) {
            if (inOrder[i] == preOrder[preOrderStart]) {
                inOrderIndex = i;
                break;
            }
        }

        int leftLength = inOrderIndex - inOrderStart;

        TreeNode node = new TreeNode(preOrder[preOrderStart]);
        node.left = constructCore(preOrder, preOrderStart + 1, inOrder, inOrderStart, leftLength);
        node.right = constructCore(preOrder, preOrderStart + leftLength + 1, inOrder, inOrderIndex + 1, length - leftLength - 1);
        return node;
    }

    /**
     * 方法 2
     *
     * @param pre
     * @param ints
     * @return
     */

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }


    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {

        if (preL > preR) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);

        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);

        return root;

    }


    public static void main(String[] args) {


        int[] pre = {1, 2, 3, 5, 3};
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
