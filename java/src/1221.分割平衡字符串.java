/*
 * @lc app=leetcode.cn id=1221 lang=java
 *
 * [1221] 分割平衡字符串
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int l = 0, r = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R'){
                r++;
            } else {
                l++;
            }
            if (l == r && l != 0) {
                res++;
                l = 0; r = 0;
            }
        }
        return res;
    }
}
// @lc code=end

