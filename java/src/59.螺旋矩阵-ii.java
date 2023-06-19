/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int maxNum = n * n, curNum = 1;
        int row = 0, column = 0;
        int[][] directions = {{0,1}, {1,0},{0,-1}, {-1,0}}; //注意顺序
        int directionIndex = 0;
        while(curNum <= maxNum) {
            res[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || res[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return res;
    }
}
// @lc code=end

