package pointToOffer;

/**
 *  Q: 圆圈中最后剩下的数字
 *  0，1，... n-1 这 n 个数字排成一个圆圈。
 *  从数字 0 开始，每次从这个圆圈里删除第 m 个数字。
 *  求出这个圆圈里剩下的最后一个数字。
 *
 *
 *  A: 就是约瑟夫环！
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P300_LastNumberInCircle {

    public int lastRemaining(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

}
