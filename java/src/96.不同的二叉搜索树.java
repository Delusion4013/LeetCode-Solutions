/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return count(1,n);
    }

    private int count(int lo, int hi) {
        if (lo > hi) return 1;
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;
        return res;
    }
}
// @lc code=end

