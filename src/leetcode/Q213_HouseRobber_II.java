package leetcode;

/**
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author kaikanwu
 * created on 5/10/2020
 */
public class Q213_HouseRobber_II {


    /**
     * Time:O(N)
     * Space:O(1)
     */
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 由于头尾相邻，不能计算这种情况，所以将去掉尾的情况计算一次，去掉首的情况计算一次，取两者的最大值
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));

    }


    // 这里的方法与 Q80 一致
    private int rob(int[] nums, int first, int last) {
        int pre2 = 0;
        int pre1 = 0;

        for (int i = first; i <= last; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
