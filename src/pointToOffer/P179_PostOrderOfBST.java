package pointToOffer;

/**
 *  Q: 二叉搜索树的后序遍历序列
 *  输入一个整数数组，判断该数组是不是某二叉搜索书的后序遍历结果。
 *  如果是返回 true， 否则返回 false。
 *
 *  假设输入数组的任意两个数字都不互相同。
 *
 *  A:
 *  1. 需要熟悉什么是BST？
 *     - BST的特点是，任意一个节点的值都大于其左子树中的任意节点，小于其右子树的任意节点
 *     - BST 的中序遍历是有序的
 *
 *  2. 题目中问的是后序遍历，后序遍历的特点是很容易找到根节点
 *
 *
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P179_PostOrderOfBST {

    public static boolean verifySequenceOfBST(int[] sequence) {

        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return verify(sequence, 0, sequence.length - 1);
    }


    private static boolean verify(int[] sequence, int first, int last) {

        if (last - first <= 1) {
            return true;
        }
        // 后序遍历的最后一个节点就是根节点
        int root = sequence[last];
        int curIndex = first;

        while (curIndex < last && sequence[curIndex] <= root) {
            curIndex++;
        }

        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }

        return verify(sequence, first, curIndex - 1) && verify(sequence, curIndex, last - 1);


    }


    public static void main(String[] args) {
        //      8
        //    /   \
        //   6     10
        //  / \   /  \
        // 5  7  9   11

        int[] test = {5, 7, 6, 9, 11, 10, 8};
        int[] test2 = {7,4,6,5};

        System.out.println(verifySequenceOfBST(test));
        System.out.println(verifySequenceOfBST(test2));


    }




}
