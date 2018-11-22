package pointToOffer;

/**
 *  Q: 把数字翻译成字符串
 *  给定一个数字，我们按照如下规则把它翻译成字符串。
 *  0-> "a", 1->"b"... 11->"l"...25-> "z"
 *  一个数字能有多少种翻译？
 *  例如 12258 能有多少种翻译，分别是"bccfi","bwfi", "bczi", "mcfi","mzi"
 *  请实现一个函数，计算一个数字能有多少种翻译方法。
 *
 *
 *
 *  A： 这题是典型的可以用两种思路理解：
 *      1.自顶向下的递归方法（缺点是会重复计算子问题）
 *      2.自底向上的动态规划方法
 *
 *
 *
 *
 * @author kaikanwu
 * @date 21/11/2018
 */
public class P231_TranslateNumbersToStrings {

    /**
     * LeetCode 91 原题
     *
     * @param s
     * @return
     */
    public int numDecoding(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {

            // 注意 substring（）方法，取值是前闭后开
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

}
