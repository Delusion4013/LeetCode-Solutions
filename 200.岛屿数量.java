/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid == null || grid.length == 0) return 0;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ++islands;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int i, int j) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
// @lc code=end

