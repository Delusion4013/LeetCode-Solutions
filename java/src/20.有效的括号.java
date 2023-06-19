import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stk = new LinkedList<Character>();
        int n = s.length();
        if (n % 2 != 0) return false;
    
        for (int i = 0; i < n; i++) {
            char tmp = s.charAt(i);
            if (tmp == ')') {
                if (stk.isEmpty() || stk.peek() != '(' ) {
                    return false;
                }
                stk.pop();
            } else if (tmp == ']') {
                if (stk.isEmpty() || stk.peek() != '[' ) {
                    return false;
                }
                stk.pop();
            } else if (tmp == '}') {
                if (stk.isEmpty() || stk.peek() != '{' ) {
                    return false;
                }
                stk.pop();
            } else {
                stk.push(tmp);
            }
        }


        return stk.isEmpty();

    }
}
// @lc code=end

