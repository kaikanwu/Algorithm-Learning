package leetcode;

/**
 *  Q:  编写一个函数，其作用是将输入的字符串反转过来。
 *
 *      示例 1:
 *      输入: "hello"
 *      输出: "olleh"
 *
 *      示例 2:
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 * @author kaikanwu
 * @date 06/12/2018
 */
public class Q344_ReverseString {

    /**
     * Time:    O(n)
     * Space:   O(n)
     * 使用了长度为 n 的辅助空间
     *
     */
    public String reverseString(String s) {

        if (s == null) {
            return null;
        }

        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();

        while (i < j) {

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

       return new String(chars);

    }


}
