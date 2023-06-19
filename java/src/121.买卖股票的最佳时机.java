/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int[] dp = new int[prices.length + 1];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i-1]);
            res = Math.max(res, prices[i] - dp[i-1]);
        }
        return res;
    }
}
// @lc code=end

