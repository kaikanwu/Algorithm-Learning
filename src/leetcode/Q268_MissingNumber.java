package leetcode;

/**
 *  Q:  给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 *      示例 1:
 *      输入: [3,0,1]
 *      输出: 2
 *
 *      示例 2:
 *      输入: [9,6,4,2,3,5,7,0,1]
 *      输出: 8
 *
 *      说明:
 *      你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * @author kaikanwu
 * @date 03/04/2019
 */
public class Q268_MissingNumber {

    /**
     * Time:  O(n)
     * Space: O(1)
     * 两个相同的数亦或为0   ->    a ^ a = 0;
     *                          0 ^ b = b;
     *  所以把数组中的数和 0 ~ n 的数都亦或起来，剩下的数就是所求的数
     */
    public int missingNumber(int[] nums) {

        int n = nums.length;
        int result = n;
        for (int i = 0; i < n; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }
}
