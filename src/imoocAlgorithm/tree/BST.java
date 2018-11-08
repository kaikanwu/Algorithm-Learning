package imoocAlgorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树
 *
 * @author kaikanwu
 * @date 07/11/2018
 *
 * 由于 Key 需要比较，所以 extends Comparable<Key>
 */
public class BST<Key extends Comparable<Key>, Value> {


    /**
     *  树中的节点为私有类，外界不需要了解 BST 中节点的具体实现。
     */
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = node.left;
            this.right = node.right;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    /**
     *  节点的记数
     */
    private int count;


    /**
     * 构造函数，默认为一颗空的二叉搜索树
     */
    public BST() {
        root = null;
        count = 0;
    }

    /**
     * size()
     * @return 树中节点的个数
     */
    public int size() {
        return count;
    }


    /**
     *
     * @return 布尔值：BST是否为空
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * insert（）
     * 插入一个新的数据对（key, value）
     * @param key
     * @param value
     */
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }


    /**
     *  contain
     *
     * @param key BST是否包含 键值为Key 的数据
     * @return 布尔值
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     *  Search
     *  这里设置 search 方法返回value
     * @param key
     * @return value
     */
    public Value search(Key key) {
        return search(root, key);
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }


    /**
     * 广度优先遍历 - 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node node  = queue.remove();

            System.out.println(node.key);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }


    /**
     *  寻找二叉搜索树的最小键值
     * @return
     */
    public Key minimum() {
        assert count != 0;
        Node minNode =  minimum(root);
        return minNode.key;
    }


    /**
     *  寻找BST 的最大键值
     * @return
     */
    public Key maximum() {
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }

    /**
     * 移除最小值的节点
     */
    public void removeMin() {
        if (root != null) {
            root = removeMin(root);
        }
    }

    /**
     * 移除最大值的节点
     */
    public void removeMax() {
        if (root != null) {
            root = removeMax(root);
        }
    }

    /**
     * 从二分搜索树中删除键值为key的节点
     * @param key
     */
    public void remove(Key key){
        root = remove(root, key);
    }




    /**
     * ============================
     * insert 辅助函数
     * ============================
     *  向以 node 为根的二分搜索树中，插入节点（key, value）, 使用递归算法
     *
     * @param node
     * @param key
     * @param value
     * @return 返回插入新节点后的，二分搜索树的根节点
     */
    private Node insert(Node node, Key key, Value value) {

        // 使用递归函数时，一定不能忘记终止条件
        if (node == null) {
            count++;
            return new Node(key, value);
        }

        // 如果等于，就更新节点的值
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        }
        else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }


    /**
     * ======================
     *  contain 的辅助函数
     * ======================
     * @param node
     * @param key
     * @return
     */
    private boolean contain(Node node, Key key) {

        // 处理递归到底的结果
        if (node == null) {
            return false;
        }

        if (node.key == key) {
            return true;
        }
        else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        }
        else {
            return contain(node.right, key);
        }
    }

    /**
     * ========================
     * search 的辅助函数
     * ========================
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key){

        // 一定要记得递归的
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        }
        else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        }
        else {
            return search(node.right, key);
        }


    }


    /**
     * 前序遍历
     * @param node
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.value);
            inOrder(node.right);
        }
    }


    /**
     *  后续遍历
     * @param node
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.value);
        }
    }

    /**
     * 返回BST最小键值所在的节点
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }


    /**
     * 返回BST最大键值所在的节点
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }


    /**
     * 移除BST的最小节点，并重新使其成为一个BST
     * @param node
     * @return
     */
    private Node removeMin(Node node) {

        if (node.left == null) {

            Node rightNode = node.right;
            node.right = null;
            count -- ;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 移除BST的最d大节点，并重新使其成为一个BST
     * @param node
     * @return
     */
    private Node removeMax(Node node) {

        if (node.right == null) {

            Node leftNode = node.left;
            node.left = null;
            count--;
            return leftNode;
        }


        node.right = removeMax(node.right);
        return node;
    }


    /**
     * 删除掉以node为根的二分搜索树中键值为key的节点,递归算法
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, Key key){

        if( node == null ){
            return null;
        }


        if( key.compareTo(node.key) < 0 ){
            node.left = remove( node.left , key );
            return node;
        }
        else if( key.compareTo(node.key) > 0 ){
            node.right = remove( node.right, key );
            return node;
        }
        else{   // key == node->key

            // 待删除节点左子树为空的情况
            if( node.left == null ){
                Node rightNode = node.right;
                node.right = null;
                count --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if( node.right == null ){
                Node leftNode = node.left;
                node.left = null;
                count--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = new Node(minimum(node.right));
            count ++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count --;

            return successor;
        }
    }




}
