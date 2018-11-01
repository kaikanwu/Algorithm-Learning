package pointToOffer;

/**
 *  Q: 数值的整数次方
 *  实现函数 double Power(double base, int exponent), 求 base 的 exponent 方。
 *  不能使用库函数。且不用考虑大数问题。
 *
 *  A：
 *  1. 注意这里的 exponent 指数可能小于1，也就是0 或者负数。因为是int 型，所以不会是小数。
 *  2. 当指数为负数的时候，可以先对指数求绝对值，算出次方的结果后，对这个结果求倒数，就是答案。
 *
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P110_DoublePower {

    public static double power(double base, int exponent) {
        //先要考虑边界问题
        // 注意：当指数为 0 的时候有种特殊情况，0的0次方在数学上没有意义，所以这里需要和面试官说明。
        // 其他数字的0 次方结果都是1
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        // 考虑指数可能为负数
        boolean isNegative = false;

        // 当指数为负数的时候，先将指数求绝对值
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        // 这里根据书中的公式，可以通过递归求解，每次递归n都减少一半，
        // 因此整个算法的时间复杂度是O（logN)
        double result = power(base * base, exponent / 2);
        // double result = power(base* base, exponent >> 1);
        // 注意这里的 exponent/2 可以用exponent >> 1 代替。（右移运算符）

        // 根据书中的公式，当 指数为奇数的时候
        if (exponent % 2 != 0) {
            result = result * base;
        }

        return isNegative ? 1 / result : result;
    }


    public static double power2(double base, int exponent) {

        if (exponent == 0) {
            return 1.0;
        }
        if (exponent == 1) {
            return base;
        }

        boolean isNegative = false;

        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }

        double result = power(base * base, exponent / 2);

        if (exponent % 2 == 1) {
            result = result * base;
        }

        return isNegative ? 1 / result : result;
    }


    public static void main(String[] args) {

        double base = 0;
        int exponent = 0;

        System.out.println(power(base, exponent));



    }

}
