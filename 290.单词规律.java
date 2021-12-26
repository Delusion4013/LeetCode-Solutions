import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> str2ch = new HashMap<>();
        Map<Character, String> ch2str = new HashMap<>();
        int m = s.length();
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char ch = pattern.charAt(p);
            if (i >= m) {
                return false;
            }
            int j = i;
            while (j < m && s.charAt(j) != ' ') {
                j++;
            }
            String tmp = s.substring(i, j);
            if (str2ch.containsKey(tmp) && str2ch.get(tmp) != ch) {
                return false;
            }
            if (ch2str.containsKey(ch) && !tmp.equals(ch2str.get(ch))) {
                return false;
            }
            str2ch.put(tmp, ch);
            ch2str.put(ch, tmp);
            i = j + 1;
        }
        return i >= m;
    }
}
// @lc code=end

