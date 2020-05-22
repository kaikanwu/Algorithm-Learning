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
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
