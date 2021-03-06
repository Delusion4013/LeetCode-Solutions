/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ret |= (n & 1) << (31 - i );
            n >>>= 1;
        }
        return ret;
    }
}
// @lc code=end

