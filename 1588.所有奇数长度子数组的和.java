/*
 * @lc app=leetcode.cn id=1588 lang=java
 *
 * [1588] 所有奇数长度子数组的和
 */

// @lc code=start
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + arr[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int length =1; i+length <= n; length+=2) {
                int end = i + length - 1;
                res += pre[end+1] - pre[i];
            }
        }
        return res;
    }
}
// @lc code=end

