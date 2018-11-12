package pointToOffer;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  Q: 从上到下打印二叉树
 *  从上到下打印出二叉树的每个节点，同一层节点按照从左到右的顺序打印
 *
 *
 *  A：
 *  这是一个遍历题
 *  level-order
 *
 *  1. 首先熟悉队列 queue 的操作
 *  insert -- add(e)  -  offer(e)
 *  remove -- remove() - poll() 返回队列的第一个元素，并删除
 *  examine -- element() - peek()
 *  优先考虑右侧的方法，右侧的方法返回值不存在时返回 null
 *
 *  思路：使用队列来进行层次遍历
 *
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P171_PrintTreeFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode<Integer> root) {

        if (root == null) {
            return null;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {

            for (int qSize = queue.size(); qSize > 0; qSize--) {

                TreeNode<Integer> t = queue.poll();

                // 如果队列的第一个数为空 则跳出循环
                if (t == null) {
                    continue;
                }

                result.add(t.val);
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }


        return result;

    }



    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
//        root.left.left = new TreeNode<>(4);
//        root.left.right = new TreeNode<>(5);
//        root.right.left = new TreeNode<>(6);
//        root.right.right = new TreeNode<>(7);

        P171_PrintTreeFromTopToBottom print = new P171_PrintTreeFromTopToBottom();
        System.out.println(print.PrintFromTopToBottom(root));

    }




}
