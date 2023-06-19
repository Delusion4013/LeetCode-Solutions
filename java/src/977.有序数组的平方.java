/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] res = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                res[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                res[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[index] = nums[i] * nums[i];
                --i;
            } else {
                res[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }
        return res;
    }
}
// @lc code=end

