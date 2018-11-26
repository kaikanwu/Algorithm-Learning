package leetcode;

/**
 *  给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 *  回文字符串 -> 正反都能读通的字符串
 *  "aba"
 *  "abca" 可以删除'c'
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q680_ValidPalindrome {

    public boolean validPalindrome(String s) {

        int i = -1;
        int j = s.length();

        while (++i < --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s , i, j-1) || isPalindrome(s, i+1, j);
            }
        }
        return true;

    }


    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;

    }

}
