package pointToOffer;

import java.util.Arrays;

/**
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P78_JumpFloor2 {

    public int JumpFloor(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);

        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target - 1];
    }


}
