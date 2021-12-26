/*
 * @lc app=leetcode.cn id=600 lang=java
 *
 * [600] 不含连续1的非负整数
 */

// @lc code=start
class Solution {
    public int findIntegers(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                n -= val;
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
}

// 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones/solution/bu-han-lian-xu-1de-fei-fu-zheng-shu-by-l-9l86/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
// @lc code=end

