import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};


    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && !seen[ni][nj]) {
                    seen[ni][nj] = true;
                    res[ni][nj] = res[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                }

            }
        }


        return res;
    }

}
// @lc code=end

