/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int area = Math.min(height[lo], height[hi]) * (hi - lo);
            res = Math.max(area, res);
            if (height[lo] <= height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        // Brute Force
        // for (int lo = 0; lo < n; lo++) {
        //     for (int hi = n - 1; hi > lo; hi--) {
        //         int h = Math.min(height[hi],height[lo]);
        //         int tmp = (hi - lo) * h;
        //         res = Math.max(tmp, res);                
        //     }
        // }

        return res;
    }
}
// @lc code=end

