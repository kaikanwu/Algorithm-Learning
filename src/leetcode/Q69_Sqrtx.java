package leetcode;

/**
 *  Q:  实现 int sqrt(int x) 函数。
 *
 *      计算并返回 x 的平方根，其中 x 是非负整数。
 *
 *      由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 *      sqrt -> square root(平方根)
 *
 *  A:  一个数 x 的平方根一定在 0 ~ x 中，并且满足 sqrt = x / sqrt 。
 *      所以可以利用 二分查找 在 0 ~ x 中找sqrt。
 *
 *
 * @author kaikanwu
 * @date 04/12/2018
 */
public class Q69_Sqrtx {
    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        int l = 1;
        int r = x;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            }
            else if (mid > sqrt) {
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        // 在循环条件 l<= r 并且循环退出是， r 总是比 l 小
        // 以 x=8 为例， 平方根为 2.8284... 最后应该返回 2 而不是 3，当程序退出循环时
        // l 比 r 大 1，所以应该返回小的数，也就是 r。
        return r;

    }
}
