/*
 * @lc app=leetcode.cn id=1646 lang=java
 *
 * [1646] 获取生成数组中的最大值
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] gen = new int[n + 1];
        gen[0] = 0;
        gen[1] = 1;
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                gen[i] = gen[i/2];
                max = Math.max(max, gen[i]);
            }
            else {
                gen[i] = gen[i/2] + gen[i/2+1];
                max = Math.max(max, gen[i]);
            }

        }
        return max;
    }
}
// @lc code=end

