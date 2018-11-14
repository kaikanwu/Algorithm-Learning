package pointToOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *  Q: 最小的 K 个数
 *  输入 n 个整数，找出其中最小的 k 个数。
 *  例如输入 4、5、1、6、2、7、3、8 这8个数，
 *  则最小的4个数是1、2、3、4
 *
 *  A:
 *  这是经典的 TOP K 问题
 *
 *  1. 最简单的方法是使用排序，然后最前面 k 个数就是最小的 k 个数。时间复杂度是 O(n*logn)，空间复杂度O(1)，修改原数组
 *  2. 执行 K 次直接选择排序, TC: O(n*k), SC:O(1), 修改了原数组
 *  3. 使用快排的 partition 函数求出第 K 小的元素， TC:O(n), SC:O(1), 修改原数组
 *  4. 维护一个长度为 K 的升序数组，用二分法更新元素， TC: O(n*logK), SC: O(k), 不修改原数组
 *  5. 创建并维护一个长度为 K 的最大堆， TC: O(n*logK), SC:O(K), 不修改 ---> 适合处理海量数据
 *
 * @author kaikanwu
 * @date 13/11/2018
 */
public class P209_KLeastNumbers {


    /**
     *  一、使用选择排序
     *  O(N * K)
     *  适合N 和 K 较小的情况
     *
     * @param arr
     * @param k
     * @return
     */
    public static int getLeastNumbers1(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k > arr.length) {
            return 0;
        }

        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        // 第 K 小， 也即是排序后下标为 k-1 的元素
        return arr[k - 1];
    }


    /**
     *  方法二： 使用分区函数
     *  O（n）
     *  修改原函数
     *
     * @param arr
     * @param k
     * @return
     */
    public static int getLeastNumbers2(int[] arr, int k) {

        if (arr == null || arr.length == 0 || k > arr.length) {
            return 0;
        }

        int left = 0;
        int right = arr.length-1;
        int bound = partition(arr, left, right);


        while (bound != k - 1) {

            if (bound < k - 1) {
                bound = partition(arr, bound + 1, right);
            }
            else {
                bound = partition(arr, left, bound - 1);
            }
        }

        return arr[k - 1];
    }

    /**
     * 辅助函数 partition
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {

            while (arr[right] > pivot && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (arr[left] < pivot && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
        }
        arr[left] = pivot;
        return left;
    }


    /**
     *  方法三、大小为 K 的最小堆
     *
     *  TC： O（N * log K）---> 在 N 个元素中选出前 K 个
     *  特别适合处理海量数据
     *
     *  思路：
     *  应该使用"大根堆"，来维护"小根堆"。
     *  （而不能直接创建一个小根堆并设置一个大小，企图让小根堆中的元素都是最小元素。）
     *  维护一个大小为 K 的小根堆的过程如下：在添加一个元素之后，如果大根堆的大小大于 K,
     *  那么将大根堆的堆顶元素去除。
     *
     *
     * @param arr
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumbers3(int[] arr, int k) {

        if (k > arr.length || k <= 0) {
            return new ArrayList<>();
        }

        // 注意这个优先队列里的参数
        // 如果不重写 Comparator，按照默认情况，将是升序排列
        // 生成最大堆使用 o2-o1, 生成最小堆使用 o1-o2
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : arr) {
            maxHeap.offer(num);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }




        return new ArrayList<>(maxHeap);

    }

    public static void main(String[] args) {
        int[] test1 = {6, 1, 3, 5, 4, 2};
        System.out.println(getLeastNumbers1(test1, 5));
        int[] test2 = {6, 1, 3, 5, 4, 2};
        System.out.println(getLeastNumbers2(test2,5));
        int[] test3 = {6, 1, 3, 5, 4, 2,10,11,12,13,14};
        System.out.println(getLeastNumbers3(test3,5));


    }







}
