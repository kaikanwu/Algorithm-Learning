package structure;

/**
 *
 * 二叉查找树
 *
 * @author kaikanwu
 * created on 5/24/2020
 */
public class BinarySearchTree {

    private Node tree;

    /**
     * 查找
     */
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


    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {

            if (data > p.data) {
                // 如果右子树为空，则直接插入新节点
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
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
