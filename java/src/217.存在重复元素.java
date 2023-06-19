import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) {
            if (s.contains(num)) return true;
            s.add(num);
        }
        return false;
    }
}
// @lc code=end

