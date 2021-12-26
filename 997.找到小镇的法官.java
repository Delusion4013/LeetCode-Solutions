/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] fans = new int[n+1];
        int[] stars = new int[n+1];
        for (int[] pair : trust) {
            int fan = pair[0];
            int star = pair[1];
            fans[star]++;
            stars[fan]++;
        }
        for (int i = 1; i <= n; i++) {
            if (fans[i] == n-1 && stars[i] == 0) return i;
        }
        return -1;
    }
}
// @lc code=end

