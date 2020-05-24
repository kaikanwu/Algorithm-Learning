package structure;

/**
 *
 * 二叉树的查找
 *
 * @author kaikanwu
 * created on 5/24/2020
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;

        while (p != null) {
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }


    public static class Node {

        private int data;

        private Node left;

        private Node right;

        public Node(int data) {
            this.data = data;
        }

    }





}
