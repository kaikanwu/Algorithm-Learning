package hua;

import java.util.*;

/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            String input = scanner.next();

            for (int i = input.length() - 1; i >= 0; i--) {
                System.out.print(input.charAt(i));

            }

        }



    }
}
