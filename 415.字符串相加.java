/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int i = n - 1, j = m - 1;
        int carry = 0, n1 = 0, n2 = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            // if (i >= 0) {
            //     n1 = (num1.charAt(i) - '0');
            // } else {
            //     n1 = 0;
            // }
            // if (j >= 0) {
            //     n2 = (num2.charAt(j) - '0');
            // } else {
            //     n2 = 0;
            // }
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            // if (sum >= 10) {
            //     sum -= 10;
            //     carry = 1;
            // } else {
            //     carry = 0;
            // }
            i--; j--;
        }
        if (carry == 1) {sb.append(carry);}
        return sb.reverse().toString();
    }
}
// @lc code=end

