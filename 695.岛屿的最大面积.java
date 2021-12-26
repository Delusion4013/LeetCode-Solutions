/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i,j));
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        int ans = 1;
        for (int index = 0; index < 4; index++) {
            int mx = x + dx[index], my = y + dy[index];
            ans += dfs(grid, mx, my);
        }
        return ans;
    }
}
// @lc code=end

