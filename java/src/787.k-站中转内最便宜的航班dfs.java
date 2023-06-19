/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

// @lc code=start
class Solution {
    int INF = 100000007;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] memo = new int[n][k+2];
        int res = dfs(flights, src, dst,k+1, memo);
        return res >= INF ? -1 : res;
    }



    public int dfs(int[][] flights, int cur, int dst, int k, int[][] memo) {
        if (k < 0) return INF;
        if (cur == dst) return 0;
        // 记忆化搜索
        if (memo[cur][k] != 0) return memo[cur][k];
        int min = INF;
        for (int[] flight : flights) {
            if (flight[0] == cur) {
                min = Math.min(min, dfs(flights, flight[1], dst, k-1, memo)+flight[2]);
            }
        }
        memo[cur][k] = min;
        return min;
    }
}
// @lc code=end

