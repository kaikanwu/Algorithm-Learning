package pointToOffer;

/**
 *  Q: 我们把只包含因子2、3和5的数成为丑数。
 *  求从小到大排列的第1500个丑数。默认1为第一个丑数。
 *  例如： 6和8是丑数，14不是，14包含因子7
 *
 *
 *  A：
 *  1. 从1 开始递增，逐个判断每个数是否是丑数。优点是直观，缺点是不高效。
 * @author kaikanwu
 * @date 22/11/2018
 */

public class P240_GetUglyNumbers {

    /**
     *  方法一：从1开始遍历每个数，判断是否是丑数
     *
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {

        if (index <= 0) {
            return 0;
        }

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index) {
            number++;

            if (isUgly(number)) {
                uglyFound++;
            }

        }
        return number;
    }


    private static boolean isUgly(int number) {

        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        // number==1? true:false
        return number==1;

    }


    /**
     * 方法二： 使用 dp
     * @param index
     * @return
     */
    public static int getUglyNumber2(int index) {

        if (index <= 6) {
            return index;
        }

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;

        for (int i = 1; i < index; i++) {

            int next2 = dp[i2] * 2;
            int next3 = dp[i3] * 3;
            int next5 = dp[i5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));

            if (dp[i] == next2) {
                i2++;
            }
            if (dp[i] == next3) {
                i3++;
            }
            if (dp[i] == next5) {
                i5++;
            }
        }

        return dp[index - 1];

    }





    /**
     * for test
     * @param args
     */
    public static void main(String[] args) {


        System.out.println(getUglyNumber(10));
        System.out.println(getUglyNumber2(10));
    }

}
