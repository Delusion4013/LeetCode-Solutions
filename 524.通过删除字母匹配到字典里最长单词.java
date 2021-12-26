import java.util.List;

/*
 * @lc app=leetcode.cn id=524 lang=java
 *
 * [524] 通过删除字母匹配到字典里最长单词
 */

// @lc code=start
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            if (match(s, word)) {
                if (word.length() > res.length()) {
                    res = word;
                } else if (word.length() == res.length()) {
                    if (word.compareTo(res) < 0) {
                        res = word;
                    }
                }
            }
        }
        return res;
    }

    private boolean match(String s, String word) {
        int s1 = 0, s2 = 0;
        while (s2 < word.length() && s1 < s.length()) {
            if (word.charAt(s2) == s.charAt(s1)) {
                ++s2;
            }
            ++s1;
        }
        return s2 == word.length();
        
    }
}
// @lc code=end

