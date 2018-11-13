package pointToOffer;

/**
 *  Q: 数组中出现次数超过一半的数字
 *  数组中有一个数字出现次数超过数组长度的一半，请找出这个数字。
 *
 *
 *  A：
 *  注意"超过一半"，也就是只会有一个数字
 *
 *  1. 最简单的方法是将数组排序，然后求其中位数，这样的时间复杂度是 O(n * logn)
 *  2. 用快排的分区函数求中位数（top K 问题）
 *  3. 书中一个很有趣的思路：可以看成一种特殊的缓存机制，使用两个变量 value，count，
 *  具体见下面代码
 *
 * @author kaikanwu
 * @date 13/11/2018
 */
public class P205_MoreThanHalfNumber {


    /**
     *  方法一：使用 partition
     * @param data
     * @return
     */
    public static int moreThanHalfNum1(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int left = 0;
        int right = data.length - 1;

        int k = data.length >>> 1;
        int bound = partition(data, left, right);
        while (bound != k) {
            if (bound > k) {
                bound = partition(data, left, bound - 1);
            }
            else {
                bound = partition(data, bound + 1, right);
            }
        }
        return data[k];

    }

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
     *
     *  方法二：
     *  推荐使用这个
     * @param arr
     * @return
     */
    public static int moreThanHalfNum2(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int count = 1;
        int value = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == value) {
                count++;
            }
            else if (arr[i] != value && count == 1) {
                value = arr[i];
            }
            else {
                count--;
            }
        }
        return value;



    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(moreThanHalfNum2(arr));
    }

}
