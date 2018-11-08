package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author kaikanwu
 * @date 08/11/2018
 */
public class PDD1 {


    private static int result() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in = br.readLine();
        if (in.length() <= 0) {
            return 0;
        }



        // 存到 HashMap中
        //26 个小写字母
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < in.length(); i++) {
            char word = in.charAt(i);
            // 已经存在的话 +1
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        System.out.println(map);


        Integer[] arr =  new Integer[map.size()];
        int j = 0;
        for (Integer i : map.values()
             ) {
            arr[j] = i;
            j++;
        }

        Arrays.sort(arr);


        for (Integer i: arr
             ) {

            System.out.println(i+" ");

        }

        int result = 0;
        // 把value最小的数-1， value 最大的数 +1 来计算结果
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                result += (arr[i]-1)*(arr[i]-1);
            }
            else if (i == arr.length - 1) {
                result += (arr[i]+1)*(arr[i]+1);
            }
            else {
                result += arr[i] * arr[i];
            }
        }



        return result;


    }


    public static void main(String[] args)throws IOException {

        System.out.println(result());
    }
}
