package leetcode;

/**
 *  给定两个有序整数数组 nums1 和 nums2，
 *  将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * @author kaikanwu
 * @date 26/11/2018
 */
public class Q88_MergeSortedArray {
    /**
     *  其实就是归并排序里的 merge 两个排好序的数组的操作
     *  这里的 -- 就是从大往小的排列。
     *  是最优解！使用的变量也最少！
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 || j >= 0) {

            if (i < 0) {
                nums1[index--] = nums2[j--];
            }
            else if (j < 0) {
                nums1[index--] = nums1[i--];
            }
            else if (nums1[i] > nums2[j]){
                nums1[index--] = nums1[i--];
            }
            else {
                nums1[index--] = nums2[j--];
            }
        }
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];

        int left = 0;
        int mid = m - 1;
        int right = m + n - 1;

        int i = left;
        int j = mid +1;





    }
}
