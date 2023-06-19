import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m-1;
        int left_bound = 0, right_bound = n-1;
        List<Integer> res = new LinkedList<Integer>();
        while(res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                for (int i = left_bound; i <= right_bound; i++) {
                    res.add(matrix[upper_bound][i]);
                }
            }
            upper_bound++;

            if (left_bound <= right_bound) {
                for (int j = upper_bound; j <= lower_bound; j++) {
                    res.add(matrix[j][right_bound]);
                }
            }
            right_bound--;

            if (upper_bound <= lower_bound) {
                for (int i = right_bound; i >= left_bound; i--) {
                    res.add(matrix[lower_bound][i]);
                }
            }
            lower_bound--;

            if (left_bound <= right_bound) {
                for (int j = lower_bound; j >= upper_bound; j--) {
                    res.add(matrix[j][left_bound]);
                }
            }
            left_bound++;
        }

        return res;
    }
}
// @lc code=end

