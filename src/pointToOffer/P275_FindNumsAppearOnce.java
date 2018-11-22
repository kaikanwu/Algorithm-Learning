package pointToOffer;

/**
 *  Q: 数组中数字的出现的次数
 *  数组中只出现一次的两个数字。
 *  一个整型数组里除了两个数字之外，其他数字都出现了两次。
 *  请写出程序找出这两个只出现一次的数字。
 *  要求：时间复杂度 TC:O(n), SC:O(1)
 *
 *  example : {2,4,3,6,3,2,5,5} -> 4,6
 *
 *  A:
 *  位运算相关
 *
 *  关于元素出现次数的总结：见简书收藏文章
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P275_FindNumsAppearOnce {

    public static int[] findNumsAppearOnce(int[] arr) {

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result ^= arr[i];
        }

        int indexOf1 = findFirstBit1(result);
        int ret[] = new int[]{0, 0};

        if (indexOf1 < 0) {
            return ret;
        }

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & indexOf1) == 0) {
                ret[0] ^= arr[i];
            }
            else {
                ret[1] ^= arr[i];
            }
        }

        return ret;
    }

    private static int findFirstBit1(int num) {

        if (num < 0) {
            return -1;
        }

        int indexOf1 = 1;
        while (num != 0) {

            if ((num & 1) == 1) {
                return indexOf1;
            }
            else {
                num = num >> 1;
                indexOf1 *=2;
            }
        }
        return -1;

    }



}
