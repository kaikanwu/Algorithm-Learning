package pointToOffer;

import java.util.Arrays;

/**
 *  Q: 扑克牌中的顺子
 *
 *  从扑克牌随机中抽5张，判断是不是顺子（连续的）。
 *  2~10 为本身， A 为 1， J 为 11， Q 为 12， K 为 13。
 *  大小王可以为任意数字。
 *
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P298_ContinousCards {
    public boolean isContinuous(int[] nums) {

        if (nums.length < 5) {

            return false;
        }

        Arrays.sort(nums);

        // 统计癞子数量
        int cnt = 0;
        for (int num : nums) {
            if (num == 0) {

                cnt++;
            }
        }


        // 使用癞子去补全不连续的顺子
        for (int i = cnt; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {

                return false;
            }
            cnt -= nums[i + 1] - nums[i] - 1;
        }

        return cnt >= 0;
    }
}
