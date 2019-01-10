package leetcode;

/**
 *  Q:  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 *      写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *  A:  二分搜索：迭代（也可以用递归来写二分搜索。）
 *
 * @author kaikanwu
 * @date 09/01/2019
 */
public class Q704_BinarySearch {

    /**
     * 二分搜索的迭代版本，也就是使用循环。
     *
     * Time:O(logn)
     * Space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        // 在 arr[l,r] 的返回里查找 target
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            //int mid = (l+r)/2; -> 求两个边界的中间值
            //避免 int 范围溢出
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
        // no target
        return -1;

    }
}
