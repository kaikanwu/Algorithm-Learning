package leetcode;

/**
 *  给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q633_SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {

        int i = 0;
        int j = (int)Math.sqrt(c);

        while (i <= j) {

            int sum = i*i + j*j;

            if (sum == c) {
                return true;
            }
            else if (sum< c){
                i++;
            }

            else {
                j--;
            }
        }
        return false;

    }



}
