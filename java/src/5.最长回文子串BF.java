/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (isPalindrome(tmp)) {
                    if (tmp.length() > res.length()) {
                        res = tmp;
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String tmp) {
        int left = 0, right = tmp.length() - 1;
        while (left < right) {
            if (tmp.charAt(left) != tmp.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
// @lc code=end

