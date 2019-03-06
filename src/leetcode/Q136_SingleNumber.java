package leetcode;

import java.util.*;

/**
 *  Q:  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *      说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 *  A:  线性时间复杂度：就是要求算法为常数级的时间复杂度 O(n)，且不能用额外的辅助空间
 *      1. 位运算 2. 使用一个set
 *
 * @author kaikanwu
 * @date 12/01/2019
 */
public class Q136_SingleNumber {

    /**
     * Time:O(n), Space O(1)
     * 亦或操作：1. 两个值相同时，结果为0；两个值不同，结果为1
     *         2. 0^任何数字 = 数字本身
     *         3. 亦或操作满足交换定律
     * 其他位操作：与：&
     *
     *
     * 根据以上特性，我们可以理解把所有数字放在一起做亦或操作，会让两个相同的数字亦或为0，
     * 最后就剩下 0^ single number = single number
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;

    }


    /**
     * Time: O(n), Space:O(n)
     */
    public int singleNumber2(int[] nums) {

        Set<Integer> set = new HashSet<>();

        int sum = 0;
        int uniqueSum = 0;

        for (int num : nums) {

            if (!set.contains(num)) {
                uniqueSum += num;
                set.add(num);
            }
            sum += num;
        }

        // 根据题意除了所求的数字，其他数字都是有2个
        return 2 * uniqueSum - sum;
    }

}
