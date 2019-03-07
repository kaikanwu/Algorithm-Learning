package leetcode;

/**
 *  Q:  给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *      案例:
 *      s = "leetcode", 返回 0.
 *      s = "loveleetcode", 返回 2.
 *      默认小写
 *
 *  A:
 *
 *
 * @author kaikanwu
 * @date 07/03/2019
 */
public class Q387_FirstUniqueChar {


    /**
     * Time: O(n)
     * Space:
     * @param s
     * @return
     */
    public int firstUnique(String s) {

        // 26：这里指一共有26个英文字符，可以使用更多来表示更多的字符
        int[] freq = new int[26];

        // 遍历 String ，将出现的频率添加到 freq 数组中
        for (int i = 0; i < s.length(); i++) {
            // 存储字符串，如果字符是 a,那么 'a'- 'a'，
            // 在 ASCII 中是 0 ，也就是将该字符放在 index 0 的位置上，后面同理

            freq[s.charAt(i) - 'a'] ++;
        }
        // 再次遍历，返回 出现次数为 1 的字符的下标
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;


    }
}
