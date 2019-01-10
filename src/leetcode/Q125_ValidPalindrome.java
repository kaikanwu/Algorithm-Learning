package leetcode;

/**
 *  Q:  给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *      说明：本题中，我们将空字符串定义为有效的回文串。
 *
 *      示例 1:
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: true
 *
 *      示例 2:
 *      输入: "race a car"
 *      输出: false
 *
 *  A:  使用双指针来判断字符是否相等。在判断前需要根据题意来处理空格、大小写、标点符号。
 *
 * @author kaikanwu
 * @date 06/12/2018
 */
public class Q125_ValidPalindrome {

    /**
     * 方法1：使用双指针
     *
     * Time:O(n) Space:O(1)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\p{Punct}","");


        int i = 0;
        int j =s.length()-1;

        while (i <= j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            else {
                i++;
                j--;
            }

        }
        return true;

    }

}
