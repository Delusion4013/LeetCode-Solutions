/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1]*nums[i-1];
        }

        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}
// @lc code=end

