package pointToOffer;




class TreeLinkNode{
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * Q.给定一个二叉树和其中的一个节点，如何找出 "中序遍历的下一个节点" ？
 *   树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 *
 * A.
 * 1. 中序遍历： 左根右
 * 2. 先画出一个二叉树的图，方便理解做题
 *
 * @author kaikanwu
 * @date 28/10/2018
 */
public class P65_NextNodeInBinaryTrees {

    public TreeLinkNode getNext(TreeLinkNode pNode) {

        //  首先要时刻记得 中序遍历的顺序是 左根右
        // 1. 如果一个节点的右子树不为空，那么该节点的下一个节点就是该右子树的最左节点
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            //1.1 该子树的左节点不为空时，就是该左节点
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //  2. 否则（该节点的右子树为空），向上找第一个左链接 指向的树包含该节点的祖先节点
        else {

            //  2.1 该节点的下一个节点不为空，如果为空就是最后个节点
            while (pNode.next != null) {
                //  2.2 下一个节点设为它的父节点
                TreeLinkNode parent = pNode.next;
                // 2.3 如果给的节点是父节点的左节点，则该父节点就是该节点的下一个节点（左根右）
                if (parent.left == pNode) {
                    return parent;
                }
                //  2.3如果不是...,也就是说该节点是父节点的右节点，则需要向上找，直到符合上面的if判断
                pNode = pNode.next;
            }

        }
        return null;
    }


}
