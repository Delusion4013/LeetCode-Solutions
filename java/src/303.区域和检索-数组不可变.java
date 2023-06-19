/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {

    int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

