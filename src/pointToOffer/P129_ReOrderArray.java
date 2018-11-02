package pointToOffer;

/**
 *  Q: 调整数组顺序使奇数位于偶数前面
 *
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *  使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *  （NowCoder 中有加一个要求就是："并保证奇数和奇数，偶数和偶数之间的相对位置不变。"）
 *
 *  A：
 *
 *
 *
 *
 * @author kaikanwu
 * @date 01/11/2018
 */
public class P129_ReOrderArray {
    public static void reOrderArray(int[] arr) {


        int oddCount = 0;
        //找出数组中奇数的个数
        for (int val: arr) {
            if (val % 2 == 1) {
                oddCount++;
            }
        }

        // 将输入的数组赋值到一个新的数组
        int[] copy = arr.clone();

        int i = 0;
        int j = oddCount;
        for (int num : copy) {
            // 先复制奇数到原数组
            if (num % 2 == 1) {
                arr[i++] = num;
            }
            // 再复制偶数到原数组
            // j 代表奇数的个数，也就是前面已经复制完的元素的个数，所以偶数也就是从index j开始
            else {
                arr[j++] = num;
            }
        }

    }


    public static void main(String[] args) {

        int[] arr = { 2, 2,1, 6,5,3};
        reOrderArray(arr);

        for (int i: arr
             ) {

            System.out.print(i + " ");

        }

    }
}
