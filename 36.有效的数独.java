import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    //官方用的hashmap，但采用数组更方便
    // 难点在于如何将3x3的坐标转化为对应的box坐标
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] col = new int[9][9];
        int[][] sbox = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    // 关键代码
                    int index_box = (i/3)*3+j/3;
                    if (rows[i][num]==1) return false;
                    else { rows[i][num]=1; }
                    if (col[j][num]==1) return false;
                    else { col[j][num]=1; }
                    if (sbox[index_box][num]==1) return false;
                    else { sbox[index_box][num]=1; }
                }
            }
        }
        return true;
    }
}
// @lc code=end

