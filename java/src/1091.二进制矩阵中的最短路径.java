import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {

    int[] dx = {1,1,1,-1,-1,-1,0,0};
    int[] dy = {1,-1,0,1,-1,0,-1,1};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<Integer> queue = new LinkedList<Integer>();

        int m = grid.length, n = grid[0].length;
        boolean flag = false;
        int ans = 0;
        if (grid[0][0] == 1) return -1;
        queue.offer(0);

        while (flag != true && !queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int p = queue.poll();
                int x = p / n, y = p % n;
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (grid[x][y] == 1) continue;
                if (x == m - 1 && y == n - 1) {
                    flag = true;
                    break;
                }
                grid[x][y] = 1;

                for (int j = 0; j < 8; j++) {
                    int xx = x + dx[j], yy = y + dy[j];
                    if (xx < 0 || yy < 0 || xx >= m || yy >= n) continue;
                    if (grid[xx][yy] == 1) continue;
                    queue.offer(xx*n+yy);
                }
            }
            ans++;
        }
        return flag == true ? ans : -1;
    }
}
// @lc code=end

