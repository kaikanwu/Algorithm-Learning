package leetcode;

/**
 *  给定两个有序整数数组 nums1 和 nums2，
 *  将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * @author kaikanwu
 * @date 26/11/2018
 */
public class Q88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int index1 = m - 1;
        int index2 = n - 1;
        int indexMerge = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {

            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            }
            else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            }
            else if (nums1[index1] > nums2[index2]){
                nums1[indexMerge--] = nums1[index1--];
            }
            else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
