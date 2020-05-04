package leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * <p>
 * 回文字符串 -> 正反都能读通的字符串
 * "aba"
 * "abca" 可以删除'c'
 *
 * @author kaikanwu
 * created on  24/11/2018
 */
public class Q680_ValidPalindrome {

    public boolean validPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;

    }


    private boolean isPalindrome(String s, int i, int j) {

        // i == j 的情况，就是返回 true
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;

    }

}
