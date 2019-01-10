package leetcode;

/**
 *  Q:  实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 *  A: 方法1：使用循环来计算，会超时。方法二：使用位运算。
 *
 * @author kaikanwu
 * @date 09/01/2019
 */
public class Q50_Pow {

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public double myPow(double x, int n) {

        double result = 1;
        // 取绝对值的目的是，防止 N 为负数
        // 这里用long 转换的目的是：如果 n 是 int 的最小值，取绝对值后会溢出
        long N = Math.abs((long) n);

        for (int i = 0; i <N ; i++) {
            result *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    /**
     * Time:O(logn)
     * Space: O(1)
     */
    public double myPow2(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);

        // 方法相当于将指数用二进制表示
        while (N != 0) {
            // 在一个循环里来检查，N的最低位是否为1，如果为1，
            // 则让 result 乘以当前的底数 x
            if ((N & 1) == 1) {
                result *= x;
            }
            // 更新 x 的值
            x *= x;
            // N 向右移动一位
            N >>= 1;
        }

        return n < 0 ? 1 / result : result;
    }

}
