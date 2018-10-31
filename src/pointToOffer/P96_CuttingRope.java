package pointToOffer;

/**
 *
 * Q：剪绳子问题
 *  等于 LeetCode 343 Integer Break
 *  给你一根长度为n的绳子，请把绳子剪成m段（m,n 都是整数且>1）
 *  求每段绳子长度的最大乘积是多少？
 *
 *  A：
 *  1. 动态规划
 *  2. 贪心算法
 *
 * @author kaikanwu
 * @date 31/10/2018
 */
public class P96_CuttingRope {


    /**
     * 方法一、动态规划
     * @param n
     * @return
     */
    public static int cuttingRope1(int n) {

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max( dp[i], Math.max(  j * (i - j), dp[j] * (i - j) ));
            }
        }

        return dp[n];
    }


    /**
     * 方法二： 使用贪心算法
     * @param n
     * @return
     */
    public static int cuttingRope2(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        // 尽可能多的减去长度为3的绳子段
        int timesOf3 = n / 3;

        //当绳子最后剩下的长度为4的时候，不能再减去长度为3的绳子段，（如果减去3,就是 1和3 ，乘积为3，没有2*2=4 大）
        //此时更好的方法是把绳子剪成长度为2的两段
        if (n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        //剩下的长度用来除以2
        int timesOf2 = (n-timesOf3*3)/2;

        //Math.pow(a，3)方法 -> 就是求a 的3次方
        // 所以这里返回的就是最后所求的最大乘积
        return (int) (Math.pow(3, timesOf3) * (int) (Math.pow(2, timesOf2)));
    }


    public static void main(String[] args) {


        int length = 100;
        System.out.println(cuttingRope1(length));
        System.out.println(cuttingRope2(length));

    }
}
