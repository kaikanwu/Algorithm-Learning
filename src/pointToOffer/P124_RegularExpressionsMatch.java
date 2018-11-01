package pointToOffer;

/**
 *  Q. 正则表达式匹配
 *  请实现一个函数用来匹配包含'.' 和 '*' 的正则表达式。
 *  模式中的字符 '.' 表示任意一个字符， 而 '*' 表示它前面的字符可以出现任意次数（包含0次）
 *  在本题中，匹配是指字符串的所有字符匹配整个模式。
 *
 *  例如： aaa 和 "a.a" 和 "ab*ac*a" 匹配，"aa.a" 和"ab*a"不匹配
 *
 *  A.
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P124_RegularExpressionsMatch {


    /**
     * 比较 str 和 pattern 是否匹配
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pattern[j - 1] == '*') {

                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j-1];
                        dp[i][j] |= dp[i-1][j];
                        dp[i][j] |= dp[i][j-2];

                    }else {
                        dp[i][j] = dp[i][j - 2];
                    }

                }
            }
        }


        return dp[m][n];


    }




}
