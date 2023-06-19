/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {

    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        int n = word.length();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = dfs(board, visited, word, i, j, 0);
                if(flag) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, String word, int x, int y, int index) {
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        boolean result = false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int dx =  x + directions[i][0], dy = y + directions[i][1];
            if (dx >= 0 && dy >= 0 && dx < board.length && dy < board[0].length && !visited[dx][dy]) {
                boolean flag = dfs(board, visited, word, dx, dy, index+1);
                if (flag == true) {
                    result = true;
                    break;
                }
            }                
        }
        visited[x][y] = false;
        return result;
    }
}
// @lc code=end

