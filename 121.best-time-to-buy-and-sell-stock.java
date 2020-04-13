/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}

    public int maxProfitUgly(int[] prices) {
        int l = prices.length;
        if (l ==0) {
            return 0;
        }
        int max = 0;
        int m = prices[l - 1];

        for (int i = l - 2; i >= 0; i--) {
            max = Math.max(max, m - prices[i]);
            m = Math.max(m, prices[i]);
        }
        return max;
    }

    // N^2 solution
    public int maxProfit2(int[] prices) {
        int l = prices.length;
        int max = 0;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}
// @lc code=end

