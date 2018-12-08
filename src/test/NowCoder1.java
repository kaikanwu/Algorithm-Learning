package test;


import java.util.*;
/**
 * @author kaikanwu
 * @date 08/12/2018
 */
public class NowCoder1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int result = 0;
        int[] arr = new int[3];
        while (n>0) {
            for (int i = 0; i < 3; i++) {
                arr[i] = scanner.nextInt();
            }
            n--;
            int x = arr[0];
            int y = arr[1];
            int k = arr[2];
            if (x > k || y > k) {
                System.out.println("-1");
                continue;
            }
            if ((x + y) % 2 == 0) {
              result = k;
            }

        }

    }

}
