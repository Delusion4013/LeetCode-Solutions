/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        // int n = s.length();
        // int[] res = new int[52];
        // for (int i = 0; i < n; i++) {
        //     if (Character.isUpperCase(s.charAt(i))) {
        //         res[s.charAt(i)-'A']++;
        //     } else {
        //         res[s.charAt(i) - 'a' + 26]++;
        //     }
        // }
        // int ans = 0, maxOdd = 0;
        // for (int i = 0; i < 52; i++) {
        //     if (res[i] % 2 == 0) {
        //         ans += res[i];
        //     } else {
        //         ans += res[i] - 1;
        //         maxOdd = 1;
        //     }
        // }
        // return ans+maxOdd;

        // A quicker version
        int count[] = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

