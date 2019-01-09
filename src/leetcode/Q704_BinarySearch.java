package leetcode;

/**
 *  Q:  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *      写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * @author kaikanwu
 * @date 09/01/2019
 */
public class Q704_BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;

    }
}
