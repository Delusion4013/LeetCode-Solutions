import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        StringBuffer tmp = new StringBuffer();
        int n = digits.length();
        if (n == 0) return res;
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(digits, res, phoneMap, 0, tmp);
        return res;
    }

    public void backtrack(String digits, List<String> res, Map<Character, String> phoneMap, int i, StringBuffer tmp) {
        if (i == digits.length()) {
            res.add(tmp.toString());
        } else {
            char ch = digits.charAt(i);
            String letters = phoneMap.get(ch);
            int count = letters.length();
            for (int j = 0; j < count; j++) {
                tmp.append(letters.charAt(j));
                backtrack(digits, res, phoneMap, i+1, tmp);
                tmp.deleteCharAt(i);
            }
        }
    }
}
// @lc code=end

