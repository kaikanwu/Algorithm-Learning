package pointToOffer;

/**
 *  Q: 青蛙跳台阶：
 *  一只青蛙一次可以跳上1级台阶，也可以跳上 2级台阶。
 *  求该青蛙跳上一个n级台阶总共有多少种跳法。
 *
 *  A：
 *  使用动态规划来求解：
 *  跳到第n个台阶，有两种可能：
 *      1. 从n-1个台阶跳1个台阶
 *      2. 从n-2个台阶跳2个台阶
 *      所以只需要求出跳到 1. 情况下的跳法和 2. 情况下的跳法 相加即可。
 *      再按照上面的想法，也就是不断重复这个过程。
 *
 *      所以递推公式： F（n） = F(n-1) + F(n-2)
 *      这其实就是fibonacci 数列
 *
 *
 *
 * @author kaikanwu
 * @date 30/10/2018
 */
public class P77_FrogJumpFloor {


    /**
     * 方法一：自底向上，使用循环迭代的方法。
     *
     * @param n
     * @return
     */
    public static int FrogJumpFloor(int n) {

        if (n <= 2) {
            return  n;
        }

        int pre2 = 1, pre1 = 2;
        int result = 1;

        for (int i = 2; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }


    /**
     * 方法二： 自顶向下，使用递归
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {

        if (target <= 2) {
            return target;
        }else{
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(FrogJumpFloor(10));
        System.out.println("=========");
        System.out.println(JumpFloor(10));
    }
}
