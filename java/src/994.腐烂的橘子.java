import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(i*n+j);
                if (grid[i][j] == 1) count++;
            }
        }
        if (count == 0) return 0;
        if (queue.isEmpty() && count != 0) return -1;
        int[][] dirs = {{0,1}, {0,-1}, {1,0},{-1,0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int row = index / n, col = index % n;
                for (int[] dir : dirs) {
                    int mrow = row + dir[0], mcol = col + dir[1];
                    if (mrow > -1 && mcol > -1 && mrow < m && mcol < n) {
                        if (grid[mrow][mcol] == 1) {
                            grid[mrow][mcol] = 2;
                            count--;
                            queue.offer(mrow*n+mcol);
                        }
                    }
                }
            }
            ++time;
        }

        return count > 0 ? -1 : time-1;
    }
}
// @lc code=end

