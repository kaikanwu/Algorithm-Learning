package huawei;

import java.util.*;

/**
 *  题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<Character> set = new LinkedHashSet<>();

        if (scanner.hasNext()) {

            String input = scanner.nextLine();
            for (int i = input.length()-1; i >=0 ; i--) {

                set.add(input.charAt(i));
            }
        }

        for (Character i: set
             ) {
            System.out.print(i);

        }

    }
}
