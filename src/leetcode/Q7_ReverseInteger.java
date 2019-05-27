package leetcode;

/**
 *  Q：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 *  示例 1:
 *      输入: 123
 *      输出: 321
 *  示例 2:
 *      输入: -123
 *      输出: -321
 *  示例 3:
 *      输入: 120
 *      输出: 21
 *  注意:
 *      假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author kaikanwu
 * @date 5/27/2019
 */
public class Q7_ReverseInteger {

    public int reverse(int x) {
        long index = 0;

        while (x != 0) {
            index = index * 10 + x % 10;
            x = x / 10;
        }
        int result = (int) index;
        //反转后整数溢出那么就返回 0。
        if (result != index) {
            return 0;
        }
        return (int) index;
    }

}
