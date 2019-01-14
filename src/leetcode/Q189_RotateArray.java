package leetcode;

/**
 *  Q: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *     输入: [1,2,3,4,5,6,7] 和 k = 3  输出: [5,6,7,1,2,3,4]
 *     输入: [-1,-100,3,99] 和 k = 2   输出: [3,99,-1,-100]
 *
 *  A: 1. 使用辅助数组 2. 反转函数
 *
 * @author kaikanwu
 * @date 14/01/2019
 */
public class Q189_RotateArray {


    /**
     * Time:O(n), Space:O(n)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int n = nums.length;
        int m = k % n;
        int i = 0;
        int[] temp = new int[n];

        for (int j = n-m; j < n; j++) {
            temp[i++] = nums[j];
        }
        for (int j = 0; j < n - m; j++) {
            temp[i++] = nums[j];
        }
        for (int j = 0; j <n ; j++) {
            nums[j] = temp[j];
        }
    }

    /**
     * Time:O(n)
     * Space:O(1)
     */
    public void rotate2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return;
        }
        int n = nums.length;
        int m = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, m - 1);
        reverse(nums, m, n - 1);




    }

    /**
     * 辅助反转函数，只需要反转三次
     */
    private void reverse(int[] nums, int i, int j ) {
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }




}
