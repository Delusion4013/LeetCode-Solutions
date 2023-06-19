import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        backtrack(res, sb, n, n);

        return res;
    }

    public void backtrack(List<String> res, StringBuffer sb, int open, int close) {
        if (close == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (open == close) {
            sb.append('(');
            backtrack(res, sb, open-1, close);
            sb.deleteCharAt(sb.length() - 1);
        } else if (open < close) {
            if (open > 0) {
                sb.append('(');
                backtrack(res, sb, open-1, close);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(')');
            backtrack(res, sb, open, close-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

