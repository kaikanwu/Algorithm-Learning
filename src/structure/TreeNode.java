package structure;

/**
 * @author kaikanwu
 * @date 25/10/2018
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
