package leetcode;

/**
 * Q:给定两个有序整数数组 nums1 和 nums2，
 * 将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明: 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * A:  使用双指针来解决。可以关联复习 Merge Sort。
 *
 * @author kaikanwu
 * @date 26/11/2018
 */
public class Q88_MergeSortedArray {
    /**
     * 其实就是归并排序里的 merge 两个排好序的数组的操作
     * 这里的 -- 就是从大往小的排列。
     * 是最优解！使用的变量也最少！
     * <p>
     * Time: O(m+n), Space: O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {


        int i = m - 1;
        int j = n - 1;
        // index 是 merge 后的最大值的下标
        int index = m + n - 1;

        // 注意这里的判断条件
        while (i >= 0 || j >= 0) {

            if (i < 0) {
                // 根据题意，num1 有足够的空间，所以这里往 nums1 放
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }


}
