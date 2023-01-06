/*
 * @lc app=leetcode.cn id=2180 lang=java
 *
 * [2180] 统计各位数字之和为偶数的整数个数
 */

// @lc code=start
class Solution {
    public int countEven(int num) {
        int y = num / 10, x = num % 10;
        int res = 5 * y, ySum = 0;
        while (y != 0) {
            ySum += y % 10;
            y /= 10;
        }
        if (ySum % 2 == 0) {
            res += x / 2 + 1;
        } else {
            res += (x+1) / 2;
        }
        return res - 1;
    }
}
// @lc code=end

class MathSolution {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int x = i, temp_sum = 0;
            while(x != 0) {
                temp_sum += x % 10;
                x /= 10;
            }
            if (temp_sum % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}

