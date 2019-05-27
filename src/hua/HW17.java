package hua;

import java.util.*;

/**
 * @author kaikanwu
 * @date 18/11/2018
 */
public class HW17 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n < 1 || n > 1000000000) {
                System.out.print("-1");

            }
            else {

                TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);

                for (int i = 1; i <= n; i++) {

                    String str = String.valueOf(i);

                    for (int j = 0; j <str.length() ; j++) {

                        if (map.containsKey(str.charAt(j))) {
                            map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                        }
                        else {
                            map.put(str.charAt(j), 1);
                        }
                    }
                }

                int[] arr = new int[10];
                int j = 0;
                for (Integer i: map.values()) {
                    arr[j++] = i;

                }

                for (int i = 0; i < 10 ; i++) {
                    if (i < 9) {
                        System.out.print(arr[i]+" ");

                    }
                    else {
                        System.out.print(arr[i]);
                    }
                }
            }


        }

    }
}
