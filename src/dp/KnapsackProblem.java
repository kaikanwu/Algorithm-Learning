package dp;

import java.util.Arrays;

/**
 * Q：
 * 给你一个可放总重量为 W 的背包和 N 个物品，对每个物品，有重量 w 和价值 v 两个属性，
 * 那么第 i 个物品的重量为 w[i]，价值为 v[i]。
 * 现在让你用这个背包装物品，问最多能装的价值是多少？
 *
 * @author kaikanwu
 * created on 12/3/2020
 */
public class KnapsackProblem {


    /**
     * @param w 物品的重量
     * @param v 物品的价值
     * @param N 物品总数
     * @param W 背包能容纳的总重量
     * @return 最多能装的价值
     */
    int dp(int[] w, int[] v, int N, int W) {

        int[][] dp = new int[N + 1][W + 1];

        // init the array -> base case
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        // tn: traversed n，已遍历过的 n
        // rw: reserved w，背包剩余的重量
        for (int tn = 1; tn < N + 1; tn++) {
            for (int rw = 1; rw < W + 1; rw++) {

                if (rw < w[tn]) {
                    // 当前背包剩余重量小于当前物品重量时，无法放入
                    dp[tn][rw] = dp[tn - 1][rw];
                } else {
                    // 做出决策：1. 放入背包的价值是：dp[tn - 1][rw - w[tn]] + v[tn]，2. 不放入的价值是：dp[tn-1][rw]
                    dp[tn][rw] = Math.max(dp[tn - 1][rw], dp[tn - 1][rw - w[tn]] + v[tn]);
                }
            }
        }
        System.out.println("after init: " + Arrays.deepToString(dp));


        return dp[N][W];
    }

    public int solveDP() {
        int N = 3, W = 5;
        int[] w = {0, 3, 2, 1};
        int[] v = {0, 5, 2, 3};

        return dp(w, v, N, W);
    }

}

