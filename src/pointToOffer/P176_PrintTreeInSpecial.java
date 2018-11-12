package pointToOffer;

import org.omg.PortableInterceptor.INACTIVE;
import structure.TreeNode;

import java.util.*;

/**
 *  Q:  之字形打印二叉树
 *  请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右打印，
 *  第二行按照从右到左打印，第三行再按照从左到右打印，以此类推。
 *
 * @author kaikanwu
 * @date 12/11/2018
 */
public class P176_PrintTreeInSpecial {

    public static ArrayList<ArrayList<Integer>> print(TreeNode<Integer> root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        boolean reverse = false;

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
            if (reverse) {
                Collections.reverse(list);
            }
            // 将下一轮反转
            reverse = !reverse;
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

        for (ArrayList<Integer> arr:print(root)
             ) {

            System.out.println(arr);

        }


    }




}
