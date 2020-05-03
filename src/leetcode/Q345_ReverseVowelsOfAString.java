package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * Given s = "leetcode", return "leotcede".
 *
 * 元音字母：a e i o u
 *
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q345_ReverseVowelsOfAString {

    // 注意不要忘记英文字符的大小写
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];

        while (i <= j) {

            // 要在判断前取出两个指针指向的字符，否则会被 i++, j-- 影响
            char ci = s.charAt(i);
            char cj = s.charAt(j);

            if (vowels.contains(ci) && vowels.contains(cj)) {
                result[i++] = cj;
                result[j--] = ci;
            } else if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else {
                result[j--] = cj;
            }
        }
        return new String(result);
    }
}
