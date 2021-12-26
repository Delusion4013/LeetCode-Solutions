/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i <= r; i++) {
            while (i <= r && nums[i] == 2) {
                swap(nums, i, r);
                r--;
            }
            if (nums[i] == 0) {
                swap(nums, i, l);
                l++;
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
// @lc code=end

