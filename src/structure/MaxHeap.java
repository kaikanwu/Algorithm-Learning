package structure;

/**
 * @author kaikanwu
 * @date 05/11/2018
 */
public class MaxHeap<Item> {

    private Item[] data;
    private int count;

    /**
     * 构造函数，构造一个空堆，可以容纳 capacity 个元素
     * @param capacity
     */
    public MaxHeap(int capacity) {
        // 由于堆中的元素是从 1 开始，所以需要初始化一个 capacity + 1 大小的数组
        data = (Item[]) new Object[capacity+1];
        count = 0;
    }

    /**
     * 返回堆中元素的个数
     *
     * @return 返回堆中元素的个数
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     *
     * @return 返回一个布尔值
     */
    public boolean isEmpty() {
        return count == 0;
    }

}
