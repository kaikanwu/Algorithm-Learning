package structure.heap;

import java.util.*;
import java.lang.*;

/**
 * @author kaikanwu
 * @date 05/11/2018
 */
public class MaxHeapShiftUp<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;


    /**
     * 构造函数，构造一个空堆，可以容纳 capacity 个元素
     * @param capacity
     */
    public MaxHeapShiftUp(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;

    }

    /**
     * 返回堆中的元素个数
     * @return 元素个数
     */
    public int size() {
        return count;
    }

    /**
     * 判断堆是否为空
     * @return 布尔值
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * 添加一个新的元素
     * @param item 想要加入到最大堆的元素
     */
    public void insert(Item item) {
        //判断加入一个元素之后，是否会超过容纳值
        assert  count +1 <= capacity;

        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }


    /**===========================
     * 添加一个元素的关键方法 shift up
     * ===========================
     *
     * @param k 添加元素的下标
     */
    private void shiftUp(int k) {

        // 当父节点小于子节点
        // 注意 这里的 k >1 要写在第二个条件之前。
        while (k>1 && data[k/2].compareTo(data[k]) < 0 ) {

            // 交换
            swap(k, k / 2);
            // 更新 k 的值，继续作比较
            k /= 2;
        }
    }

    /**
     * 交换元素
     * @param i 待交换的第一个元素
     * @param j 待交换的第二个元素
     */
    private void swap(int i, int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    public static void main(String[] args) {

        MaxHeapShiftUp<Integer> maxHeap = new MaxHeapShiftUp<>(100);

        // n 为要插入堆中元素的个数
        // m -> 元素值为[0,100)
        int n = 50;
        int m = 100;

        for (int i = 0; i < n ; i++) {
            maxHeap.insert(new Integer((int)Math.random()* m));

        }

        System.out.println(maxHeap.size());

    }



}
