package leetcode;

/**
 * @author kaikanwu
 * @date 11/08/2019
 */
public class Q746_MinCostClimbingStairs {

    /**
     * Time:O(n), Space:O(n)
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int n = cost.length;
        int[] d = new int[n];

        d[0] = cost[0];
        d[1] = cost[1];

        for (int i = 2; i < n; i++) {
            d[i] = Math.min(d[i - 1], d[i - 2]) + cost[i];
        }
        return Math.min(d[n - 2], d[n - 1]);
    }


    /**
     * Time:O(n) Space:O(1)
     */
    public int minCostClimbingStairs1(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < cost.length ; i++) {
            int cur = Math.min(first, second) + cost[i];
            first = second;
            second = cur;
            
        }
        return Math.min(first, second);
    }

}

