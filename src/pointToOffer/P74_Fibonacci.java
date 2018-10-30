package pointToOffer;

/**
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P74_Fibonacci {


    /**
     * 方法一： 按照fibonacci 函数的概念直接使用递归。
     *
     * 方法一的问题：
     *  使用递归求解的时候会重复计算一些子问题，例如，计算 f(10) 需要 f(9) 和 f(8),
     *  计算f(9) 需要 f(8) 和 f(7)， 这里 f(8) 就被重复了。
     *
     *  递归是将一个问题划分成多个子问题求解，动态规划也是如此，但是动态规划会把子问题的解缓存起来，
     *  从而避免重复求解子问题。
      */
    private static int fibonacci1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    /**
     * 方法二：
     * @param n
     * @return
     */
    private static int fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int temp1 = 0, temp2 = 1;
        int result = temp1 +temp2 , i = 3;

        while (i <= n) {
            temp1 = temp2;
            temp2 = result;
            result = temp1 + temp2;
            i++;
        }
        return result;

    }


    /**
     * 方法三
     * @param n
     * @return
     */
    private static int fibonacci3(int n) {
        if (n <= 1) {
            return n;
        }

        int[] fib = new int[n + 1];

        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];

    }


    /**
     * 方法五
     * @param n
     * @return
     */
    private static int fibonacci4(int n) {
        if (n <= 1) {
            return n;
        }

        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }


}
