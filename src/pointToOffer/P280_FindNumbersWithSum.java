package pointToOffer;

import java.util.ArrayList;

/**
 *  Q: 和为 S 的数字
 *  输入一个递增数组和一个数字s ,在数组中查找两个数，使它们的和为s.
 *  如果有多对，输出任意一对即可。
 *
 *  A： 使用双指针。
 *  一个指针指向元素较小的值，一个指针指向元素较大的值。
 *  指向较小元素的指针从头向尾遍历，指向较大元素的指针从尾向头遍历。
 *
 *  如果两个指针指向的元素的和 sum == target, 则返回指向的元素
 *  如果 sum > target, 移动指向较大元素的指针，使 sum 变小一些。
 *  如果 sum < target， 移动指向较小元素的指针，使 sum 变大一些。
 *
 *
 * @author kaikanwu
 * @date 22/11/2018
 */
public class P280_FindNumbersWithSum {


    public int[] findNumbersWithSum(int[] arr, int sum) {

        int i = 0;
        int j = arr.length - 1;
        int[] result = new int[2];


        while (i < j) {

            int cur = arr[i] + arr[j];
            if (cur == sum) {
                result[0] = arr[i];
                result[1] = arr[j];
            }
            if (cur < sum) {
                i++;
            }
            else {
                j++;
            }
        }
        return result;

    }

}
