package leetcode200.at.doublePointer;

public class Q167_TwoSum_II {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        // 不能使用重复的元素
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else {
                l ++;
            }
        }
        return null;
    }
}
