package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Q3: 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 *
 * 思路：
 *  1. HashSet 抽象成为滑动窗口
 *  2. HashMap
 *
 * @author kaikanwu
 * @date 10/11/2018
 */
public class Q3_LongestSubstring {

    /**
     * 使用 HashMap
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }
        return result;
    }


    /**
     *  方法二： 滑动窗口
     *
     *  O(2n) = O(n)
     *  空间复杂度：O(min(m, n))O(min(m,n)), 与之前的方法相同。
     *  滑动窗口法需要 O(k)O(k) 的空间，其中 kk 表示 Set 的大小。
     *  而Set的大小取决于字符串 nn 的大小以及字符集/字母 mm 的大小。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();

        int result = 0;
        int i = 0;
        int j = 0;

        while ( j < n) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                result = Math.max(result, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }



    /**
     * 暴力解法
     *
     *  O(n^3)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j <= n; j++) {
                if (allUnique(s, i, j)) {
                    return Math.max(result, j - i);
                }
            }
        }
        return result;
    }


    /**
     * 方法4
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {

        int[] freq = new int[256];

        /**
         *  滑动窗口为 s[l...r]
         */
        int l = 0;
        int r = -1;
        int result = 0;

        while (r+1 < s.length()) {

            // 由于这里的 r 值，会变换，所以 if 里需要再次判断
            if (r+1 <s.length() && freq[s.charAt(r+1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            }
            else{
                freq[s.charAt(l)]--;
                l++;
            }

            result = Math.max(result, r - l + 1);
        }
        return result;


    }

    private boolean allUnique(String s, int start, int end) {

        Set<Character> set = new HashSet<>();

        for (int i = start; i < end; i++) {
            Character c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;

    }

}
