package leetcode;

/**
 *  Q:  给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 *      示例 1:
 *
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 *      示例 2:
 *
 *      输入: s = "rat", t = "car"
 *      输出: false
 *      说明:
 *      你可以假设字符串只包含小写字母。
 *
 *
 *  A:  1. 想到的第一个方法是使用 HashMap: key 存储字符， value 存储字符出现的次数。
 *      然后和另一个字符串比较就可以。
 *
 *      2. 由于本题的字符串只包含26个小写字符，因此可以使用长度为26的整型字符数组，
 *         对字符串中出现的字符进行统计。
 *
 * @author kaikanwu
 * @date 16/12/2018
 */
public class Q242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        for (char c : s.toCharArray()) {

            // 一个字符减'a' 字符是一个数字。并且这个减法的结果不会大于26
            count[c - 'a']++;
        }

        for (char c: t.toCharArray()) {

            count[c -'a']--;
        }

        for (int i : count) {

            if (i != 0) {
                return false;
            }
        }
        return true;

    }

}
