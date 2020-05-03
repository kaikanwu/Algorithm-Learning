package leetcode;

/**
 * Q:  给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p>
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * A: 双指针
 *
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q167_TwoSum_II {

    /**
     * Time:O(n)
     * Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;
        int[] result = new int[2];

        // 不能使用重复的元素，所以条件为 i<j
        while (i < j) {

            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                // 根据题意，返回的下标不是从0开始
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum < target) {
                // 因为数组是升序，当目前的 sum 小于 target 时，只需要让 i + 1
                i++;
            } else {
                j--;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};

        Q167_TwoSum_II t = new Q167_TwoSum_II();
        int[] result = t.twoSum(arr, 9);
        for (int i : result
        ) {
            System.out.println(i);
        }
    }


}
