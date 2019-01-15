package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Q:  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *  A:  1. 暴力法：两层循环。 2.使用 HashMap
 */
public class Q1_TwoSum {

    /**
     *   TC: O(n)
     *   SC: O(n)
     */
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        int[] result = new int[2];

        HashMap<Integer,Integer> map = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;

            }
            map.put(nums[i], i);
        }

        return result;
    }


    /**
     * Time:O(n)，只遍历了一遍函数
     * Space:O(n)，使用了额外的 HashMap 做存储。
     */
    public int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numNeeded = target - nums[i];
            if (map.containsKey(numNeeded)) {
                return new int[]{map.get(numNeeded), i};
            }
            // HashMap 中 key 为数组的值， value 为数组的下标
            map.put(nums[i], i);

        }
        return new int[]{-1, -1};
    }

}
