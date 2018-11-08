package imoocAlgorithm.unionFind;

/**
 * @author kaikanwu
 * @date 07/11/2018
 */
public class UnionFind2 {


    private int[] parent;
    private int count;

    public UnionFind2(int count) {

        parent = new int[count];
        this.count = count;
        //  初始化
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }
    }

    /**
     *  查找一个元素 p 对应的集合编号
     *  O(h) 复杂度， h 为树高
     * @param p
     * @return
     */
    private int find(int p) {
        assert (p >= 0 && p < count);

        // 不断去查询自己的父节点，直到查找到根节点
        // 根节点的特点 parent[p] == p
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }


    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     *  合并元素 p 和元素 q
     *  O(h) 时间复杂度 ， h 为树的高度
     * @param q
     * @param p
     */
    public void unionElements(int q, int p) {

        int qRoot = find(q);
        int pRoot = find(p);

        if (qRoot == pRoot) {
            return;
        }

        parent[pRoot] = qRoot;


    }
}
