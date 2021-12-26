import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> row = new HashSet<Integer>();
        Set<Integer> col = new HashSet<Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer i : row) {
            int temp = i.intValue();
            for (int j = 0; j < n; j++) {
                matrix[temp][j] = 0;
            }
        }
        for (Integer i : col) {
            int temp = i.intValue();
            for (int j = 0; j < m; j++) {
                matrix[j][temp] = 0;
            }
        }
    }
}
// @lc code=end

