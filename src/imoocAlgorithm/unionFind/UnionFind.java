package imoocAlgorithm.unionFind;

/**
 * 第一版UnionFind
 *
 * @author kaikanwu
 * @date 07/11/2018
 */
public class UnionFind {

    /**
     * 第一个版本的 unionFind 本质是一个数组
     */
    private int[] id;
    private int count;


    public UnionFind(int n) {
        count = n;
        id = new int[n];

        // 初始化，每一个id[i] 指向自己
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找过程，查找元素 p 对应的集合编号
     * @param p
     * @return
     */
    private int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    /**
     * 查看两个元素是否所属同一个集合
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            return;
        }

        //  合并的过程
        //  遍历一遍所有的元素，将两个元素所属的集合编号合并
        for (int i = 0; i < count; i++) {
            if (id[i] == pID) {
                // 发现 id[i] 等于 pID, 则将它改写为 qID
                id[i] = qID;
            }
        }
    }

}
