import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1894 lang=java
 *
 * [1894] 找到需要补充粉笔的学生编号
 */

// @lc code=start
class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) return 0;
        for (int i = 1; i < n; i++) {
            chalk[i] += chalk[i-1];
            if (chalk[i] > k) return i;
        }
        int tmp = k % chalk[n-1];

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (chalk[mid] <= tmp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
// @lc code=end

