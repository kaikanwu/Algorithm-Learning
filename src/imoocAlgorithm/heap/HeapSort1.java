package imoocAlgorithm.heap;


/**
 *  堆排序
 *  O(n * logn)
 *
 * @author kaikanwu
 * @date 05/11/2018
 */
public class HeapSort1 {


    /**
     * 算法不允许产生实例
     */
    private HeapSort1() {

    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;

        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

        //添加元素
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }

        // 将提取的元素倒序添加到数组中，也就是从小到大排列
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }

    }

    public static void main(String[] args) {
        int n = 100;

        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 1000);

        HeapSort1.sort(arr);

        SortTestHelper.printArray(arr);
//
//        SortTestHelper.testSort2("imoocAlgorithm.heap.HeapSort1", arr);
//        return;
    }




}
