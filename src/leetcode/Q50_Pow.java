package leetcode;

/**
 * @author kaikanwu
 * @date 09/01/2019
 */
public class Q50_Pow {
    /**
     * Time: O(N)
     * Space: O(1)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        double result = 1;
        long N = Math.abs((long) n);

        for (int i = 0; i <N ; i++) {
            result *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    public double myPow2(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);

        while (N != 0) {
            if ((N & 1) == 1) {
                result *= x;
            }
            x *= x;
            N >>= 1;
        }

        return n < 0 ? 1 / result : result;
    }

}
