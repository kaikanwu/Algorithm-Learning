package imoocAlgorithm.heap;

/**
 * @author kaikanwu
 * @date 05/11/2018
 */
public class MaxHeap<Item extends Comparable> {

    private Item[] data;
    private int count;
    private int capacity;

    /**
     * 构造函数一
     * @param capacity 堆的最大容纳值
     */
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0 ;
        this.capacity = capacity;
    }


    /**
     *  构造函数二 ----> Heapify
     * @param arr 需要排序的数组
     */
    public MaxHeap(Item[] arr) {

        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        capacity = n;

        // 将输入的数组赋值给 data[]
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        //堆中元素还是 n 个
        count = n;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }




    }


    /**
     * 获取堆的最大值
     * @return
     */
    public Item getMax() {
        assert count > 0;
        return data[1];
    }

    /**
     * 堆的元素个数
     * @return 元素个数
     */
    public int size() {
        return count;
    }

    /**
     * 堆是否为空
     * @return 布尔值
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入一个元素
     * @param item 待插入的元素
     */
    public void insert(Item item) {
        assert count+1 <= capacity;

        data[count+1] = item;
        count++;
        shiftUp(count);
    }


    /**=====================================
     * 从最大堆中取出堆顶元素，即存储在堆中的最大值
     * =====================================
     * @return 堆顶元素
     */
    public Item extractMax() {
        assert  count > 0;
        Item ret = data[1];

        swap(1, count);
        count--;
        shiftDown(1);

        return ret;
    }


    /**================================================
     * 将交换后的堆顶元素向下调整，使堆依然维持最大堆的定义和性质。
     * （尝试将索引为 K 的元素向下移动）
     * ================================================
     * @param k 堆顶元素的index
     */
    private void shiftDown(int k) {

        // while 循环先判断，这个节点是否有child --> 2*k <= count
        while (2 * k <= count) {
            //在此轮循环中，data[k] 和 data[j] 交换位置
            int j = 2 * k;
            // j+1 <= count 表示是否有 右child
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            //  如果父节点大，则直接退出这个while 循环
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            // 交换
            swap(k, j);
            k = j;
        }
    }


    /**
     * 将元素调整上移
     * @param k 待调整元素的index
     */
    private void shiftUp(int k) {

        //注意堆是从 1 开始计数的，所以 k 要大于 1， 而不是 0
        while (k > 1 && data[k/2].compareTo(data[k]) < 0) {
            swap(k, k/2);
            k /= 2;
        }

    }






    /**
     * 交换两个元素在数组中的位置
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Item item = data[i];
        data[i] = data[j];
        data[j] = item;
    }


}
