/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] 乘积小于K的子数组
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++){
            prod *= nums[right];
            while(prod >= k) prod /= nums[left++];
            ans += right - left + 1; 
        }
        return ans;



        // Brute Force
        // int res = 0;
        // int n = nums.length;
        // for (int i = 0; i <= n-1; i++) {
        //     int temp = nums[i];
        //     if (temp >= k) continue;
        //     res++;
        //     for (int j = i+1; j < n; j++) {
        //         temp *= nums[j];
        //         if(temp >= k) break;
        //         else res++;
        //     }
        // }
        // return res;
    }
}
// @lc code=end

