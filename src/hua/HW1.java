package hua;

import java.util.Scanner;

/**
 * 题目描述
 * 输入任意个字符串，将其中的小写字母变为大写，大写字母变为小写，其他字符不用处理；
 * 输入描述:
 * 任意字符串：abcd12#%XYZ
 * 输出描述:
 * 输出字符串：ABCD12#%xyz
 * 示例1
 * 输入
 * abcd12#%XYZ
 * 输出
 * ABCD12#%xyz
 *
 *
 * @author kaikanwu
 * @date 17/11/2018
 */
public class HW1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(convert(str));

    }

    /**
     *  convert
     * @param str
     * @return
     */
    private static String convert(String str) {

        if (str == null) {
            return null;
        }

        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            // 大写转小写
            if (ch[i] >= 65 && ch[i] <= 90) {
                ch[i] += 32;
            }
            else if (ch[i] >= 97 && ch[i] <= 122) {
                ch[i] -= 32;
            }
        }

        return new String(ch);


    }




}
