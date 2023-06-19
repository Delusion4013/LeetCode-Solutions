import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        List<Integer> last = triangle.get(n-1);
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = last.get(i);
        }
        for (int i = n-2; i >= 0; i--) {
            List<Integer> line = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + line.get(j);
            }
        }

        return dp[0][0];
        
    }
}
// @lc code=end

