package pointToOffer;

/**
 *  Q: 礼物的最大价值
 *  在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0 ）
 *  你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。
 *  给定一个棋盘及上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 *  A：
 *  1. 动态规划
 *  2. 深度优先搜索
 *
 *  动态规划的方法更佳
 *
 *  举例：
 *  1   10  3   8
 *  12  2   9   6
 *  5   7   4   11
 *  3   7   16  5
 *
 *  最大价值是 1+12+5+7+7+16+5 = 53
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P233_MaxValueOfGifts {

    /**
     *  使用动态规划
     * @param values
     * @return
     */
    public static int getMost(int[][] values) {

        if (values == null || values.length == 0 || values[0].length == 0) {
            return 0;
        }

        int n = values[0].length;
        int[] dp = new int[n];

        for (int[] value: values) {

            dp[0] += value[0];

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i], dp[i - 1]) + value[i];
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};

        System.out.println(getMost(arr));

    }
}
