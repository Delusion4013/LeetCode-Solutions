/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n]; 
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                res[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }

        int index = res[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(res[index]);
            index++;
        }
        return ans.toString();


    }

    // Used for add method
    public String addString(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int t1 = i < 0 ? 0 : num1.charAt(i) - '0';
            int t2 = j < 0 ? 0 : num2.charAt(j) - '0';
            int prod = t1 + t2 + carry;
            sb.append(prod % 10);
            carry = prod / 10;
            i--; j--;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

