package hua;

import java.util.*;

/**
 * 求int型正整数在内存中存储时1的个数
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW14 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {

            int input = scanner.nextInt();
            String s = Integer.toBinaryString(input);

            int count = 0;
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '1') {
                    count++;
                }

            }
            System.out.println(count);
        }

    }
}
