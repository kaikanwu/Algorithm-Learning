package test;
import java.util.*;
import java.io.*;
/**
 * Q:
 *
 *
 * @author kaikanwu
 * @date 29/10/2018
 */
public class PDD2 {
    /**
     * 给定两个版本字符串version1和version2，
     * 比较两个版本的大小，
     * 如果version1 > version2， 则返回1；
     * 如果version1 < version2， 则返回-1；
     * 如果version1 = version2， 则返回0。
     * version非空，只包含数字和字符 '.'
     *
     * 再给一组数据
     * 输入：
     * 1.0.1
     * 1
     * 输出：
     * 1
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception{


        System.out.println(compare());

    }


    private static int compare() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String v1 = br.readLine();
        String v2 = br.readLine();


        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");

        int min = Math.min(arr1.length,arr2.length);

        int max = Math.max(arr1.length, arr2.length);





        for (int i = 0; i < min ; i++) {

            int n1 = Integer.parseInt(arr1[i]);
            int n2 = Integer.parseInt(arr2[i]);
            if (n1 > n2) {
                return 1;
            }
            else if (n1 < n2){
                return -1;
            }
        }

        if (arr1.length == arr2.length) {
            return 0;
        }

        for(int i =min;  i< max; i++){

            if (arr1.length > arr2.length) {
                if (Integer.parseInt(arr1[i])!= 0) {
                    return 1;
                }
            }
            else  {
                if (Integer.parseInt(arr2[i]) != 0) {

                    return -1;
                }
            }
        }

        return 0;

    }

}
