/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length(), m = magazine.length();
        if (m < n) return false;
        int[] ran = new int[26];
        int[] mag = new int[26];
        for (int i = 0; i < n; i++) {
            ++ran[ransomNote.charAt(i) - 'a'];
        }
        for (int j = 0; j < m; j++) {
            ++mag[magazine.charAt(j) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (ran[i] - mag[i] > 0) return false;
        }
        return true;
    }
}
// @lc code=end

