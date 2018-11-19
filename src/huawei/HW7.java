package huawei;

import java.util.Scanner;

/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW7 {


    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        long l = 0;
        if (scanner.hasNext()) {

            l = scanner.nextLong();
            prime(l);
        }

    }

    private static void prime(long l) {

        for (long i = 2; i <= l; i++) {

            if (l % i == 0) {
                System.out.print(i + " ");
                prime(l/i);
                break;
            }
        }
    }
}
