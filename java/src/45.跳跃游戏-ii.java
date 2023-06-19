/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        // Greedy
        int n = nums.length;
        int maxPosition = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (end == i) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
// @lc code=end

