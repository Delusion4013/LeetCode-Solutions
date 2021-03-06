/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // int n = nums.length;
        // for (int i = 0; i < n - 1; i++) {
        //     if (nums[i] > nums[i+1]) {
        //         return i;
        //     }
        // }
        // return n - 1;

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
// @lc code=end

