package pointToOffer;

/**
 *  Q: 输入一个整数n, 求 1~n 这 n 个整数的十进制表示中 1 出现的次数。
 *  例如，输入 1~12， 包含 1 的整数有 1 ，10， 11， 12。一共出现 5次
 *
 * @author kaikanwu
 * @date 21/11/2018
 */
public class P221_NumberOf1Between1AndN {

    /**
     * 方法一：通过遍历 1~n 的各个数，求出出现1 的次数
     * @param n
     * @return
     */
    public int numberOf1Between1AndN(int n) {

        int count = 0;

        if (n < 0) {
            return count;
        }

        for (int i = 1; i < n; i++) {
            count = count + numberOf1(i);
        }

        return count;

    }

    private int numberOf1(int i) {

        int count = 0;
        while (i != 0) {
            if (i % 10 == 1) {
                count++;
            }
            i /= 10;
        }
        return count;
    }


    /**
     * 方法二：
     * @param n
     * @return
     */
    public int numberOf1Between1AndN2(int n) {

        int count = 0;

        for (int i = 1; i < n; i *= 10) {

            int a = n / i;
            int b = n % i;
            count += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return count;

    }





}
