package hua;

import java.util.Scanner;

/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String str = scanner.next();
            // example 0xA
            str = str.substring(2);
            System.out.println(Integer.parseInt(str,16));
        }
    }
}
