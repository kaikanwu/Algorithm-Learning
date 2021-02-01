package leetcode;

import leetcode.structure.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 示例：
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * 返回 3。和等于 8 的路径有:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class Q437_PathSumIII {


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFromRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == sum) {
            result++;
        }

        result += pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
        return result;
    }


}
