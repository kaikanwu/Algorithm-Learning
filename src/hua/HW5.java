package hua;

import java.util.Scanner;

/**
 *  连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 *  长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String str = scanner.nextLine();
            StringBuilder sb = new StringBuilder(str);

            if (sb.length() % 8 != 0) {
                int n = 8 - sb.length() % 8;
                for (int i = 0; i < n; i++) {
                    sb.append("0");
                }
            }

            while (sb.length() >= 8) {
                System.out.println(sb.substring(0, 8));
                sb.delete(0, 8);
            }
        }

    }
}
