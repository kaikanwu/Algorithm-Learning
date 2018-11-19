package huawei;

import java.util.*;


/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW19 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n < 1 || n > 1000000000) {
                System.out.print("-1");

            }
            else {

               
                int[] result={0,0,0,0,0,0,0,0,0,0};
                for (int i = 1; i <= n; i++) {

                    String str = String.valueOf(i);

                    for (int j = 0; j <str.length() ; j++) {

                        String part = str.substring(j, j + 1);
                        int index = Integer.parseInt(part);
                        int count = result[index];
                        result[index] = count+1;
                    }
                }

                for (int i = 9; i >=0 ; i--) {
                    System.out.print(result[i]+" ");

                }
            }
        }
        scanner.close();

    }
}
