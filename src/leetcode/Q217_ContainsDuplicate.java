package leetcode;

import java.util.*;

/**
 *  Q:  给定一个整数数组，判断是否存在重复元素。
 *      如果任何值在数组中出现至少两次，函数返回 true。
 *      如果数组中每个元素都不相同，则返回 false。
 *
 *  A:  1. HashMap 2. HashSet 3. Arrays.sort()
 *
 * @author kaikanwu
 * @date 14/01/2019
 */
public class Q217_ContainsDuplicate {

    /**
     * Time: O(n)
     * Space: O(n)
     * HashMap
     */
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            else {
                map.put(num, 1);
            }

        }
        return false;
    }


    /**
     *  使用了 set.add() 方法返回值是 boolean 类型的特性！
     *  速度更快
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 可以简化为 （！set.add(num)）
            if (set.add(num) == false) {
                return true;
            }
        }

        return false;
    }

    /**
     *  先排序，后判断
     */
    public boolean containsDuplicate3(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;

    }



}
