/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);

        reverse(sb, 0, sb.length()-1);

        reverseEachWord(sb);

        return sb.toString();
    }   

    private StringBuilder trimSpace(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length()-1) != ' ')  {
                sb.append(c);
            }
            ++left;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            while(end < n && sb.charAt(end) != ' ') {
                ++end;
            }

            reverse(sb, start, end-1);
            start = end + 1;
            ++end;
        }
    }
}
// @lc code=end

