/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int n = timeSeries.length;
        int expired = 0;
        for (int i = 0; i < n; i++) {
            if (timeSeries[i] >= expired) {
                ans += duration;
            } else {
                ans += timeSeries[i] + duration - expired;
            }
            expired = timeSeries[i] + duration;
        }

        return ans;
    }
}
// @lc code=end

