package pointToOffer;

/**
 * ！！！！！
 *
 *  Q: 在排序数组中查找数字
 *  统计一个数字在排序数组中出现的次数。
 *  例如，输入{1，2，3，3，3，3，4，5}，和数字3。应该输出 4
 *
 *
 *  A: 考虑到数组是排序好的，应该考虑二分查找来解决问题
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P263_GetNumberFromSortedArray {

    public static int getNumberOfK(int[] arr, int k) {

        int first = binarySearch(arr, k);
        int last = binarySearch(arr, k + 1);

        return (first == arr.length || arr[first] != k) ? 0 : last - first;
    }

    /**
     *  注意 二分查找需要根据 题目的不同，而做出变化
     * @param arr
     * @param k
     * @return
     */
    private static int binarySearch(int[] arr, int k) {

        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            // 关键是这步！ 只要
            if (arr[m] >= k) {
                r = m;
            }
            else {
                l = m+1;
            }
        }
        // 注意这里返回的是 l 左边界
        return  l;
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 3, 3, 3, 6, 8};

        System.out.println(getNumberOfK(arr, 3));

    }


}
