/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Double pointer
        int n = nums.length;
        if (n == 0) return 0;
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
        // Brute Force
        // int res = Integer.MAX_VALUE;
        // int[] pre = new int[nums.length+1];
        // pre[0] = 0;
        // for (int i = 1; i <= nums.length; i++) {
        //     pre[i] = pre[i-1] + nums[i-1];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j <= nums.length; j++) {
        //         if (pre[j] - pre[i] >= target) {
        //             res = Math.min(res, j-i);
        //             break;
        //         }
        //     }
        // }

        // return res == Integer.MAX_VALUE? 0 : res;
    }
}
// @lc code=end

