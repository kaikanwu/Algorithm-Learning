package pointToOffer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Q: 分行从上到下打印二叉树
 *  从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，
 *  每一层打印到一行。
 *
 *
 *
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P174_PrintTreeInLine {

    public static ArrayList<ArrayList<Integer>> printTreeInLine(TreeNode<Integer> root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();

            for (int qSize = queue.size(); qSize > 0; qSize--) {

                TreeNode<Integer> t = queue.poll();
                if (t == null) {
                    continue;
                }

                list.add(t.val);
                queue.offer(t.left);
                queue.offer(t.right);
            }
            if (list.size() != 0) {
                result.add(list);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);

        System.out.println(printTreeInLine(root));

    }
}
