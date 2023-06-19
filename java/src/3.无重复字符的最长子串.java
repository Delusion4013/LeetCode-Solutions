import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int j = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            while (j < n && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ++j;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }
}
// @lc code=end

