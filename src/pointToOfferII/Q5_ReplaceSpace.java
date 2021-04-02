package pointToOfferII;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Q5_ReplaceSpace {

    public String replaceSpace(String s) {

        StringBuilder result = new StringBuilder();
        char space = ' ';
        for (char c : s.toCharArray()) {
            if (space == c) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


//    public static void main(String[] args) {
//        String s = "We are happy.";
//        System.out.println(replaceSpace(s));
//    }
}
