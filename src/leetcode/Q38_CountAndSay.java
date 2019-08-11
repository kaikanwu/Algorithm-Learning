package leetcode;

/**
 *  Q：报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 *  1.     1
 *  2.     11
 *  3.     21
 *  4.     1211
 *  5.     111221
 *
 *  给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *  注意：整数顺序将表示为一个字符串。
 *
 *  示例 1:
 *  输入: 1
 *  输出: "1"
 *
 *  示例 2:
 *  输入: 4
 *  输出: "1211"
 *
 *  A：
 *
 * @author kaikanwu
 * @date 5/29/2019
 */
public class Q38_CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }

        return str;
    }

}
