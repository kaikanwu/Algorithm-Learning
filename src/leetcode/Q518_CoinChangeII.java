package leetcode;

/**
 * @author kaikanwu
 * created on 7/4/2020
 */
public class Q518_CoinChangeII {


    public int change(int amount, int[] coins) {

        int[][] d = new int[coins.length+1][amount + 1];

        for (int i = 0; i <= coins.length; i++) {
            d[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int useCurCoin = j >= coins[i - 1] ? d[i][j - coins[i - 1]] : 0;
                d[i][j] = d[i - 1][j] + useCurCoin;
            }
        }


        return d[coins.length][amount];
    }


    public int change2(int amount, int[] coins) {

        if (coins == null) {
            return 0;
        }

        // 注意这里初始化后一个数组后，值都是 0
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {

            for (int i = coin; i <= amount; i++) {

                dp[i] += dp[i - coin];

            }

        }
        return dp[amount];
    }





}
