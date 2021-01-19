package leetcode;

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 */
public class Q53_MaximumSubArray {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int maxSubArray(int[] nums) {

        int pre = 0;
        int max = nums[0];

        for (int n : nums) {
            pre = Math.max(pre + n, n);
            max = Math.max(pre, max);
        }
        return max;
    }

}
