package pointToOffer;

/**
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P74_Fibonacci {


    /**
     * 方法一： 按照fibonacci 函数的概念直接使用递归。
     *
     * 方法一的问题：
     *  使用递归求解的时候会重复计算一些子问题，例如，计算 f(10) 需要 f(9) 和 f(8),
     *  计算f(9) 需要 f(8) 和 f(7)， 这里 f(8) 就被重复了。
     *
     *  递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，
     *  从而避免重复求解子问题。
      */
    private static int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    /**
     * Solution 1:  传统递归
     * <p>
     * Time:O(2^n)
     */
    int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }


    /**
     * Solution 2: use memo or hash table
     * <p>
     * Time: O(n)
     */
    int fib2(int n) {

        if (n < 1) {
            return 0;
        }

        int[] memo = new int[n];

        return helper(memo, n);
    }


    private int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);

        return memo[n];
    }


    /**
     * Solution 3: use the dp table
     *
     * Time:  O(n)
     * Space: O(n)
     */
    public int fib3(int n) {

        int[] dp = new int[n + 1];

        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    /**
     * Solution 4:
     *
     * Time: O(n)
     * Space: O(1)
     */
    public int fib4(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 1;
        int curr = 1;

        for (int i = 3; i <= n; i++) {
            int sum = pre + curr;
            pre = curr;
            curr = sum;
        }

        return curr;
    }


}
