package leetcode;


/**
 *  Q:  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *      最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *      你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  A:
 * @author kaikanwu
 * @date 15/01/2019
 */
public class Q66_PlusOne {

    /**
     * Time:O(n)
     * Space:O(n) 最差情况下需要开辟新的数组
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        int n = digits.length;
        // 从后往前遍历
        for (int i = n-1; i >=0 ; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i]+1;
                return digits;
            }
            digits[i] = 0;

        }

        int[] result = new int[n+1];
        result[0] = 1;
        return result;
    }
}
