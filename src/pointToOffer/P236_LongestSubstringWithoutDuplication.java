package pointToOffer;

import java.util.Arrays;

/**
 *  Q: 最长不含重复字符的子字符串
 *  请从字符串中找出一个最长的不包含重复字符的字符串，计算该子字符串的长度。
 *  假设字符串只含有'a'~'z'的字符。
 *  例如："arabcacfr"， 最长子字符串是"acfr"，长度为4
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P236_LongestSubstringWithoutDuplication {


    public static int longestSubstringWithoutDuplication(String str) {

        int curLen = 0;
        int maxLen = 0;

        int[] preIndexs = new int[26];
        Arrays.fill(preIndexs, -1);

        for (int curI = 0; curI < str.length(); curI++) {
            int c = str.charAt(curI)- 'a';
            int preI = preIndexs[c];
            if (preI == -1 || curI - preI > curLen) {
                curLen++;
            }
            else {
                maxLen = Math.max(maxLen, curLen);
                curLen = curI - preI;
            }

            preIndexs[c] = curI;
        }

        maxLen = Math.max(maxLen, curLen);
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("arabcacfr")
        );
    }

}
