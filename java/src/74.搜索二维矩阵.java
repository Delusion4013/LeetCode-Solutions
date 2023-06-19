/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySeachFirstColumn(matrix, target);
        if (rowIndex < 0) return false;
        return binarySearchRow(matrix[rowIndex], target);
    }

    private boolean binarySearchRow(int[] row, int target) {
        // 在行内搜索index
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == target) return true;
            else if (row[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int binarySeachFirstColumn(int[][] matrix, int target) {
        // 搜索符合条件的行
        // ???
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
// @lc code=end

