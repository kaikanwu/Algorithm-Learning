package leetcode;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个非负整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * @author kaikanwu
 * @date 24/11/2018
 */
public class Q633_SumOfSquareNumbers {


    /**
     * Time: O(N)，实际上是 O(sqrt(target))，sqrt = square root
     * Space: O(1)
     */
    public boolean judgeSquareSum(int target) {

        int i = 0;
        // 注意这里对结果的右边界做了剪枝处理
        int j = (int) Math.sqrt(target);

        while (i <= j) {

            int sum = i * i + j * j;

            if (sum == target) {
                return true;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
