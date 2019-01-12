package leetcode;

import java.util.HashSet;

/**
 *  Q:  编写一个算法来判断一个数是不是“快乐数”。
 *      一个“快乐数”定义为：
 *      对于一个正整数，
 *      每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 *      也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 *      示例:
 *      输入: 19
 *      输出: true
 *      解释:
 *      1^2 + 9^2 = 82
 *      8^2 + 2^2 = 68
 *      6^2 + 8^2 = 100
 *      1^2 + 0^2 + 0^2 = 1
 *
 *
 * @author kaikanwu
 * @date 16/12/2018
 */
public class Q202_HappyNumber {
    /**
     *  这道题目的重点在于如何去终止循环：
     *      1. n = 1
     *      2. n 在原来的出现过的数中再次出现，说明不是 happy number。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1;
    }
}