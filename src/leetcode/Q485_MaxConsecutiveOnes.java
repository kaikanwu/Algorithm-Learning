package leetcode;

/**
 * @author kaikanwu
 * created on 9/7/2020
 */
public class Q485_MaxConsecutiveOnes {


    public int findConsecutiveOnes(int[] nums) {

        int max = 0;
        int cur = 0;

        for (int n : nums) {
            cur = n == 0 ? 0 : cur + 1;
            max = Math.max(cur, max);
        }
        return max;
    }
}
