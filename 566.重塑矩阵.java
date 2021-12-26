/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] resMat = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            // Key step - mapping matrix into 1d array
            resMat[x / c][x % c] = mat[x / n][x % n]; 
        }

        return resMat;
    }
}
// @lc code=end

