import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][n-1] == 'O') {
                q.offer(new int[]{i, n-1});
                board[i][n-1] = 'A';
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = 'A';
            }
            if (board[m-1][j] == 'O') {
                q.offer(new int[]{m-1, j});
                board[m-1][j] = 'A';
            }
        }

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || board[nx][ny] != 'O') continue;
                q.offer(new int[]{nx, ny});
                board[nx][ny] = 'A';
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
// @lc code=end

