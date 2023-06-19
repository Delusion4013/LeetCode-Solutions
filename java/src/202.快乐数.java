import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int cur = n;
        while (true) {
            int num = 0;
            while (cur > 0) {
                int t = cur % 10;
                num += t * t;
                cur /= 10;
            }
            if (num == 1) {return true;}
            else if (set.contains(num)) {
                break;
            }
            cur = num;
            set.add(num);
        }
        return false;
    }
}
// @lc code=end

