package leetcode;

/**
 * @author kaikanwu
 * created on 5/5/2020
 */
public class Q70_ClimbingStairs {


    /**
     * 递归的方法：O(n^2)，会超时
     */
    public int climbingStairsRecursive(int n) {
        if (n < 2) {
            return n;
        }

        return climbingStairsRecursive(n - 1) + climbingStairsRecursive(n - 2);
    }


    /**
     * Time: O(n)
     * Space: O(1)
     */
    public int climbingStairsIterative(int n) {

        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;

        for (int i = 2; i < n; i++) {
            int cur = first + second;
            first = second;
            second = cur;
        }
        // cur 在循环内，并且最后赋值给了 second，所以返回 second
        return second;
    }


}
