import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2*v, 1);
                st.push(top);
            }
        }

        return st.peek();
    }
}
// @lc code=end

