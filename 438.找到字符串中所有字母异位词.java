import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m < n) return res;
        int[] charP = new int[26];
        for (int j = 0; j < n; j++) {
            charP[p.charAt(j)-'a']++;
        }
        int[] charS = new int[26];
        for (int i = 0; i < n; i++) {
            charS[s.charAt(i)-'a']++;
        }
        if (Arrays.equals(charS, charP)) {res.add(0);}
        for (int i = n; i < m; i++) {
            charS[s.charAt(i)-'a']++;
            charS[s.charAt(i-n)-'a']--;
            if (Arrays.equals(charS, charP)) {res.add(i-n+1);}
        }
        return res;
    }
}
// @lc code=end

