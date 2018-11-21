package pointToOffer;

import java.util.Arrays;

/**
 *  Q：把数组排成最小的数
 *  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接所有数字中最小的一个。
 *  例如输入数组{3，32，321} 最小的数就是 321323.
 *
 *  A：
 *  此题的关键在重新定义排序：如果 a,b 组成的 ab的值大于ba，就定义为 a>b，小于等于类似。
 *  比如， 3和32，由于 332 大于323，所以定义为 3 > 32。
 *  按照上述规则进行升序排列，即可得到要求的答案。
 *
 *
 * @author kaikanwu
 * @date 21/11/2018
 */
public class P227_SortArrayToAMinNumber {

    public static String printMinNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }

        int n = arr.length;
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i] + "";
        }
        // 关键代码
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

       // 用StringBuilder 的 append 来拼接字符串更好！（相比较 str += str)
        StringBuilder sb = new StringBuilder();
        for (String str : nums) {

            sb.append(str);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        int[] arr = {3, 32, 321};
        System.out.println( printMinNumber(arr));
    }
}
