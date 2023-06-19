import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

// @lc code=start
class Solution {
    int INF = 1000007;
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return dp(n, flights, src, dst, k);
    }

    public int dp(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][K+2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[dst][0] = 0;
        for (int k = 1; k <= K + 1; k++) {
            for (int[] flight : flights) {
                dp[flight[0]][k] = Math.min(dp[flight[0]][k], dp[flight[1]][k-1] + flight[2]);
            }
        }
        int ans = IntStream.of(dp[src]).min().getAsInt();

        return ans >= INF ? -1 : ans;
    }
}
// @lc code=end

