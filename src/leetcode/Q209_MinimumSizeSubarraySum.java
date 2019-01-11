package leetcode;

/**
 *  Q:  给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 *
 *      示例:
 *      输入: s = 7, nums = [2,3,1,2,4,3]
 *      输出: 2
 *      解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 *      进阶:
 *      如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * @author kaikanwu
 * @date 06/12/2018
 */
public class Q209_MinimumSizeSubarraySum {

    /**
     *  TC: O(N)
     *  SC: O(1)
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        /**
         * nums[l...r] 为我们的滑动窗口
         */
        int l = 0;
        int r = -1;
        int sum = 0;
        int result = nums.length + 1;

        while (l < nums.length) {

            if (sum < s && r+1 <nums.length) {
                r++;
                sum += nums[r];
            }
            else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                result = Math.min(result, r - l + 1);
            }
        }

        // 遍历了后，result 的值没有更新，也就是题目没有解
        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }
}
