/*
 * @lc app=leetcode.cn id=223 lang=java
 *
 * [223] 矩形面积
 */

// @lc code=start
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int cx1 = Math.max(ax1, bx1);
        int cy1 = Math.max(ay1, by1);
        int cx2 = Math.min(ax2, bx2);
        int cy2 = Math.min(ay2, by2);
        int superposition = Math.max(cx2-cx1, 0) * Math.max(cy2-cy1, 0);
        int ans = matrixArea(ax1, ay1, ax2, ay2) + matrixArea(bx1, by1, bx2, by2) - superposition;
        return ans;
    }

    private int matrixArea(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }
}
// @lc code=end

