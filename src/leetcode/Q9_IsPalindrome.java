package leetcode;

/**
 *  Q: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 *  A：
 *
 * @author kaikanwu
 * @date 23/02/2019
 */
public class Q9_IsPalindrome {

    public static boolean isPalindrome(int x) {
        int a = x;
        int h = 1;

        // 负数必不是回文数
        if (x < 0) {
            return false;
        }

        while ((a / h) >= 10) {
            h = h * 10;
        }

        while (a > 0) {
            if (a / h != a % h) {
                return false;
            }

            a = a % h;
            a = a / 10;
            h = h / 100;
        }
        return true;

    }


    /**
     * 将数字转换成字符串，使用两个下标来判断
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        String str = String.valueOf(x);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }


    /**
     *  Time： O(m), m 是 x 的字符长度
     *  Space: O(1)
     * @param x
     * @return
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = x;
        /**
         * y 表示反过来读的数，当一个 int 反转后是有可能大于 int 的
         */
        long y = 0;

        while (tmp != 0) {
            int num = tmp % 10;
            y = y * 10 + num;
            // 通过除以 10 向左移动一位
            tmp = tmp / 10;
        }
        return y == x;

    }


}
