/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {

    // 动态规划的状态为 f(i,j)，表示在范围 [i,j] 内确保胜利的最少金额。
    public int getMoneyAmount(int n) {
        int[][] f = new int[n+1][n+1];
        for (int i = n-1; i>=1; i--) {
            for (int j = i+1; j <= n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(f[i][k-1], f[k+1][j]);
                    minCost = Math.min(minCost, cost);
                }
                f[i][j] = minCost;
            }
        }
        return f[1][n];
    }
}
// @lc code=end

