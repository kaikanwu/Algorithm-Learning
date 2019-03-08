package leetcode;

/**
 *  Q:  请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *      首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *      当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，
 *      作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *      该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 *      注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *      在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 *      说明：假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。
 *      如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 *      举例:
 *      "42"                -> 42
 *      "    -42"           -> -42
 *      "4193 with words"   -> 4193
 *      "words and 987"     ->0
 *      "-91283472332"      -> -2147483648
 *
 * @author kaikanwu
 * @date 07/03/2019
 */
public class Q8_StringToIntegerATOI {

    public int myAtoi(String str) {
        int start = 0;
        int p = 0;
        int n = str.length();
        boolean negative = false;
        while (p < n && str.charAt(p) == ' '){
            p++;
        }
        if (p == n) {
            return 0;
        }

        if (str.charAt(p) == '+') {
            p++;
        } else if (str.charAt(p) == '-') {
            p++;
            negative = true;
        }

        while (p < n && str.charAt(p) == '0') {
            p++;
        }
        start = p;

        while (p < n && str.charAt(p) >= '0' && str.charAt(p) <= '9') {
            p++;
        }

        if (p == start) {
            return 0;
        }
        if (p - start > 10) {
            if (negative) {
                return Integer.MIN_VALUE;
            }else {
                return Integer.MAX_VALUE;
            }
        }


        long num = 0;
        for (int i = start; i < p; i++) {
            num = num * 10 + (str.charAt(i) - '0');
        }
        num = negative ? -num : num;


        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else {
            return (int) num;
        }

    }

}
