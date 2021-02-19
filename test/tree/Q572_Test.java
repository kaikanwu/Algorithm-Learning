package tree;

import leetcode.Q572_SubtreeOfAnotherTree;
import leetcode.structure.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Q572_Test {
    @Test
    public void test() {

        TreeNode s = new TreeNode(3);
        TreeNode sLeft = new TreeNode(4);
        sLeft.left = new TreeNode(1);
        sLeft.right = new TreeNode(2);
        s.left = sLeft;
        s.right = new TreeNode(5);

        TreeNode t = sLeft;

        Q572_SubtreeOfAnotherTree subtreeOfAnotherTree = new Q572_SubtreeOfAnotherTree();
        boolean result = subtreeOfAnotherTree.isSubtree(s, t);
        Assert.assertTrue(result);
    }

    @Test
    public void  test2() {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);
        TreeNode t = new TreeNode(1);
        Q572_SubtreeOfAnotherTree subtreeOfAnotherTree = new Q572_SubtreeOfAnotherTree();
        boolean result = subtreeOfAnotherTree.isSubtree(s, t);
        // 测试 测试
        Assert.assertTrue(result);
    }
}
