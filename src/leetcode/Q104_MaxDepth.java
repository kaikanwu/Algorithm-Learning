package leetcode;

import structure.TreeNode;

/**
 * @author kaikanwu
 * created on 5/22/2020
 */
public class Q104_MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 根据题意，只存在单个节点时，最大深度返回 1，所以这里需要对返回值 + 1
        return Math.max(left, right) + 1;
    }
}
