package leetcode;

/**
 *  Q:  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *      设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 *      注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *  A:  题目给出了三个测试用例，分析用例可以发现，
 *      当后一个数大于前一个数时，两数的差值和，就是我们所求的max profit。
 *
 * @author kaikanwu
 * @date 14/01/2019
 */
public class Q122_BestTimeToBuyAndSellStockII {

    /**
     * Time: O(n), Space: O(1)
     */
    public int maxProfit(int[] prices) {

        int result = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {

                result += prices[i] - prices[i-1];
            }
        }
        return result;
    }
}
