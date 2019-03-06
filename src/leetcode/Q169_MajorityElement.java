package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  Q:  求众数
 *      给定一个大小为 n 的数组，找到其中的众数。众数指在数组中出现次数大于 n/2 的元素。
 *      你可以假定数组非空，且总是存在众数
 *
 *  A：  根据题意，只有一个众数
 *
 * @author kaikanwu
 * @date 06/03/2019
 */
public class Q169_MajorityElement {

    /**
     * 使用了辅助的 HashMap，存储 n 个对象
     * TC: O(n)
     * SC: O(n)
     */
    public int majorityElementWithHashMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int maxNum = 0;
        int maxCount = 0;
        for (int num : nums) {
            // getOrDefault 判断 map 中是否有 num 这个 key 有的话，就使用默认值，否则 对应的value +1
            int newCount = map.getOrDefault(num, 0) + 1;
            // 把新的 value 更新到 map
            map.put(num, newCount);

            if (newCount > maxCount) {
                maxCount = newCount;
                maxNum = num;
            }
        }
        return maxNum;
    }

    /**
     *  使用摩尔投票算法
     *  Time:O(n) , Space: O(1)
     */
    public int majorityElement(int[] nums) {

        int num = nums[0];
        int count = 1;
        // 注意：这里从数组的第二个数开始比较
        for (int i = 1; i < nums.length; i++) {

            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) {
                count++;
            }else {
                count--;
            }
        }
        return num;
    }
}
