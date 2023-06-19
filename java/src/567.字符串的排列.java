import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] chars = new int[26];
        for (int i = 0; i < n; i++) {
            chars[(int)(s1.charAt(i) - 'a')]++;
        }

        for (int j = 0; j <= m - n; j++) {
            int[] tmp = new int[26];
            for (int k = 0; k < n; k++) {
                tmp[(int)(s2.charAt(j+k) - 'a')]++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (tmp[i] != chars[i]) {
                    flag = false;
                }
            }
            if (flag == true) return true;
        }

        return false;
    }
}
// @lc code=end

