package leetcode;

import java.util.HashMap;

/**
 *  Q:  给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *      这里的遵循指完全匹配，例如，
 *      pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 *      示例1:
 *      输入: pattern = "abba", str = "dog cat cat dog"
 *      输出: true
 *
 *      示例 2:
 *      输入:pattern = "abba", str = "dog cat cat fish"
 *      输出: false
 *
 *      示例 3:
 *      输入: pattern = "aaaa", str = "dog cat cat dog"
 *      输出: false
 *
 *      示例 4:
 *      输入: pattern = "abba", str = "dog dog dog dog"
 *      输出: false
 *
 *      说明:
 *      你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 *
 * @author kaikanwu
 * @date 16/12/2018
 */
public class Q290_WordPattern {
    public boolean wordPattern(String pattern, String str) {

        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String value = map.get(c);
                if (!value.equals(words[i])) {
                    return false;
                }
            }
            else if (map.containsValue(words[i])) {
                return false;
            }
            map.put(c, words[i]);
        }
        return true;
    }
}
