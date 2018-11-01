package pointToOffer;

/**
 *  Q: 实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 *  例如 9 的二进制是1001，有2个1。 所以输入9， 输出1
 *
 *
 * @author kaikanwu
 * @date 31/10/2018
 */
public class P100_NumberOf1InBinary {


    /**
     * 方法一：
     * @param n
     * @return
     */
    public static int numberOfOne1(int n) {

        int count = 0;

        while (n != 0) {
            //将这个数和 1 做与运算，只有 1 & 1 才等于1
            if ((n & 1) != 0) {
                count++;
            }
            // n 右移一位，直到整个整数变成 0 为止
           n = n >> 1;
        }

        return count;
    }


    /**
     * 方法二
     * @param n
     * @return
     */
    public static int numerOfOne2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag  = flag << 1;
        }

        return count;
    }


    /**
     * 方法三
     * @param n
     * @return
     */
    public static int numberOfOne3(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }


    public static void main(String[] args) {
        int input = 20;

        System.out.println(numberOfOne1(input));
        System.out.println(numerOfOne2(input));
        System.out.println(numberOfOne3(input));
    }



}
