package huawei;

import java.util.*;

/**
 *  题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW11 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Character> set = new LinkedHashSet<>();
        if (scanner.hasNext()) {

            String input = scanner.next();

            for (int i = 0; i < input.length(); i++) {

                set.add(input.charAt(i));
            }
        }


        int count = 0;
        for (Character c: set) {

            if (c >= 0 && c <= 127) {
                count++;
            }
        }

        System.out.println(count);
    }
}
