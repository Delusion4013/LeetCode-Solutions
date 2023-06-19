/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
       while (b != 0) {
           int carry = (a & b) << 1;
           a = a ^ b;
           b = carry;
       }
       return a;
    }
}

// 可以发现，对于整数 aa 和 bb：

// 在不考虑进位的情况下，其无进位加法结果为 \texttt{a} \oplus \texttt{b}a⊕b。

// 而所有需要进位的位为 \texttt{a \& b}a & b，进位后的进位结果为 \texttt{(a \& b) << 1}(a & b) << 1。

// 于是，我们可以将整数 aa 和 bb 的和，拆分为 aa 和 bb 的无进位加法结果与进位结果的和。


// @lc code=end

