package leetcode;

import java.util.HashMap;

/**
 * @author kaikanwu
 * @date 10/11/2018
 */
public class Q3_LongestSubstring {
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

}
