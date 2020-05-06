package leetcode;

/**
 * Q:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 *
 * @author kaikanwu
 * created on 5/6/2020
 */
public class Q198_HouseRobber {

    public int rob(int[] nums) {
        
        int pre2 = 0;
        int pre1 = 0;

        for (int i = 0; i < nums.length; i++) {

            int cur = Math.max((pre2+nums[i]),pre1);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
