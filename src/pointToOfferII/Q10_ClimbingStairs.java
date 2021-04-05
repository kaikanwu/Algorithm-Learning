package pointToOfferII;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级台阶。
 * 求该青蛙跳上一个 n 级台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * <p>
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：0 <= n <= 100
 */
public class Q10_ClimbingStairs {

    /**
     * 使用递归的方法，会超时
     * T:O(n^2)
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }
        return numWays(n - 1) + numWays(n - 2);
    }

    /**
     * 使用迭代的方式
     * T:O(n)
     * S:O(1)
     */
    public int numWays2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 2; i < n; i++) {
            int cur = (first + second) % 1000000007;
            first = second;
            second = cur;
        }
        return second;
    }

    /**
     *  T:O(n)
     *  S:O(n)
     */
    public int numWays3(int n) {
        if (n == 0 || n ==1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
           dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
