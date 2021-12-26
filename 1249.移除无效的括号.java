import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1249 lang=java
 *
 * [1249] 移除无效的括号
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == '(') {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) set.add(stack.pop());
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(i)) {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
            
        }


        return sb.toString();
    }
}
// @lc code=end

