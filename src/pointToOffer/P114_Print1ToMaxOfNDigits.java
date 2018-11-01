package pointToOffer;

/**
 *  Q: 输入数字 n， 按顺序打印出从 1 到最大的 n 位十进制数。
 *  比如输入3，则打印出1，2，3 ... 999。
 *
 *  A： 这是一个大数问题，就是不能简单的考虑直接循环打印。
 *  因为当n很大的时候，我们平常用来存储的int long 可能会发生溢出。
 *  这时候就要考虑用 字符串 或者 数组还表达大数。
 *
 *
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P114_Print1ToMaxOfNDigits {

    public void print1ToMaXOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0 );
    }


    public void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }

    }


    public static void printNumber(char[] number) {
       int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }

        while (index < number.length) {
            System.out.print(number[index++]);
        }

        System.out.println();

    }


}
