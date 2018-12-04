package leetcode;

/**
 *  Q:  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *      ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *      请找出其中最小的元素。
 *      你可以假设数组中不存在重复元素。
 *
 *
 *  A:  看到有序数组里找一个数，要马上想起来用二分查找
 *
 *
 *
 * @author kaikanwu
 * @date 04/12/2018
 */
public class Q153_FindMinimumInRoastedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= nums[r]) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
