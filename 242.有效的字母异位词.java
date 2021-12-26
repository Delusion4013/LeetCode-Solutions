/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length(), m = t.length();
        if (n != m) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            --cnt[s.charAt(i) - 'a'];
            ++cnt[t.charAt(i) - 'a'];
        }
        for (int c : cnt) {
            if (c != 0) return false;
        }
        return true;
    }
}
// @lc code=end

