package imoocAlgorithm.heap;


/**
 * @author kaikanwu
 * @date 06/11/2018
 */
public class HeapSort2 {

    /**
     * 不允许产生任何实例
     */
    private HeapSort2(){

    }

    /**
     *  SORT
     * @param arr 待排序数组
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        // 这里就是调用了新的构造函数，构造了堆结构
        // 不同的建堆方式，会有不同的性能差异
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

    }


    public static void main(String[] args) {
        int n = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10000);
        SortTestHelper.testSort("imoocAlgorithm.heap.HeapSort2", arr);

        SortTestHelper.printArray(arr);

    }

}
