package pointToOffer;

/**
 *  Q: 连续子数组的最大和
 *  输入一个整型数组，数组里有正数也有负数。
 *  数组中的一个或多个整数构成一个子数组。
 *  求所有子数组的和的最大值。要求时间复杂度为0(n)
 *
 *
 *  A：
 *  在 Java 中，整型是有范围的
 *  Inger 占32位二进制位 首位是符号位0表示正数，1表示负数。还剩31位，2的31次方是2147483648，
 *  最大数是 2^31-1, 最小数是 -2^31。
 *
 *  注意，Min_Value 取反还是等于 Min_Value。因为 2^31超过了整型最大值。
 *  Max_Value+1 也等于 Min_Value
 *
 * @author kaikanwu
 * @date 19/11/2018
 */
public class P218_FindGreatestSumOfSubArray {


    /**
     * 方法一
     * @param arr
     * @return
     */
    public int find(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        int greatestSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int val : arr) {
            sum = sum <= 0 ? val : sum + val;
            greatestSum = Math.max(greatestSum, sum);
        }

        return greatestSum;
    }

    /**
     * 方法二：动态规划
     *
     *  动态规划， 递归公式：
     *      dp[i] = arr[i]          i=0 或 dp[i-1] <= 0
     *      dp[i-1] + arr[i]        i!=0 且 dp[i-1] >0
     *      由于只需要知道前一个情况的 dp 值，因此可以省略 dp数组，申请一个变量做记录就可以
     *
     * @param arr
     * @return
     */
    public int find2(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }

        // dp[i]用于计算 以 arr[i] 为结尾元素的连续数组的最大和
        // maxdp 用于记录在上述过程中的最大的 dp 值
        int dp = arr[0];
        int maxdp = dp;
        for (int i = 1; i < arr.length; i++) {

            if (dp > 0) {
                dp += arr[i];
            }
            else {
                dp = arr[i];
            }
            if (dp > maxdp) {
                maxdp = dp;
            }
        }
        return maxdp;
    }

}
