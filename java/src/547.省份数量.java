/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vistied = new boolean[n];
        int circles = 0;
        for (int i = 0; i < n; i++) {
            if (!vistied[i]) {
                dfs(isConnected, vistied, n, i);
                circles++;
            }
        }

        return circles;
    }

    public void dfs (int[][] isConnected, boolean[] vistied, int n, int i) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !vistied[j]) {
                vistied[j] = true;
                dfs(isConnected, vistied, n, j);
            }
        }
    }
}
// @lc code=end

