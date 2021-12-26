
/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        int pointer = n - (k % n);
        int index = 0;
        for (; pointer < n; pointer++) {
            if (pointer >= n) break;
            res[index] = nums[pointer];
            index++;
        }
        for (int i = 0; i < n - (k % n); i++) {
            res[index] = nums[i];
            index++;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}
// @lc code=end

