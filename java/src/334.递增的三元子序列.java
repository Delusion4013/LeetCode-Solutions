/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
          if (num <= small) {
            small = num;
          } else if (num <= mid) {
            mid = num;
          } 
          else if (num > mid) {
            return true;
          }
        }
        return false;  
    }
}
// @lc code=end

