/*
 * @lc app=leetcode.cn id=1464 lang=java
 *
 * [1464] 数组中两元素的最大乘积
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return (nums[0]-1)*(nums[1]-1);
        }

        Arrays.sort(nums);
        return (nums[n-1]-1)*(nums[n-2]-1);
    }
}
// @lc code=end

