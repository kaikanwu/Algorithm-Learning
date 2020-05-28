package leetcode;

import java.util.List;

/**
 *  给定一个字符串和一个字符串字典，
 *  找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 *  如果答案不止一个，返回长度最长且字典顺序最小的字符串。
 *  如果答案不存在，则返回空字符串。
 *
 * @author kaikanwu
 * @date 26/11/2018
 */
public class Q524_LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {

        String longestWord = "";
        for (String target: d) {

            int l1 = longestWord.length();
            int l2 = target.length();
            if (l1 > l2 || (l1 == l2) && longestWord.compareTo(target) < 0) {
                continue;
            }
            if (isValid(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isValid(String s, String target){

        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        // 相等时即 s 包含 target 的所有字符
        return j == target.length();
    }
}
