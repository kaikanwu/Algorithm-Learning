package leetcode;

/**
 * Q:
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * <p>
 * <p>
 * 说明：
 * 1. 你可以假设数组不可变。
 * 2. 会多次调用 sumRange 方法。
 *
 * @author kaikanwu
 * created on 5/17/2020
 */
public class Q303_RangeSumQuery {


    class NumArray {


        private int[] sums;

        public NumArray(int[] nums) {

            sums = new int[nums.length + 1];

            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }

    }
}
