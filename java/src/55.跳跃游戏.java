/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // Greedy
        int maxPos = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > maxPos) return false;
            maxPos = Math.max(maxPos, i + nums[i]);
        }
        return true;


        // DP
        // dp[i] 表示跳到 i 位置时剩余的最大步数
        // int n = nums.length;
        // if (nums[0] == 0 && n != 1) return false;
        // if (nums[0] == 0 && n == 1) return true;
        // int[] dp = new int[n];
        // dp[0] = nums[0];
        // nums[n-1] = -1;
        // for (int i = 1; i < n; i++) {
        //     dp[i] = Math.max(dp[i-1]-1, nums[i]);
        //     if (dp[i] == 0 && i != n-1) return false;
        // }
        // return dp[n-1]>=0;
    }
}
// @lc code=end

