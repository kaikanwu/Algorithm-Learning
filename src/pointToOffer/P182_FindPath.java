package pointToOffer;

import structure.TreeNode;

import java.util.ArrayList;

/**
 *  Q: 二叉树中和为某一值的路径
 *  输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 *  从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P182_FindPath {

    private  static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode<Integer> root, int target) {
        if (root == null) {
            return null;
        }
        backtracking(root, target, new ArrayList<>());

        return result;
    }


    private static void backtracking(TreeNode<Integer> root, int target, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;

        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        else {
            backtracking(root.left, target, path);
            backtracking(root.right, target, path);
        }


        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(12);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(2);
        root.right.right = new TreeNode<>(3);

        System.out.println(findPath(root, 22));

    }


}
