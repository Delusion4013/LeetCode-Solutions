/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {

    //     使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
    // 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
    // 注意到以下性质：
        // 左指针左边均为非零数；
        // 右指针左边直到左指针处均为零。

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
// @lc code=end

