/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;       
       
        // int len = bookings.length;
        // int[] ans =  new int[n];
        // for (int[] booking : bookings) {
        //     int first = booking[0];
        //     int last = booking[1];
        //     int seats = booking[2];
        //     for (int i = first-1; i <= last-1; i++) {
        //         ans[i] += seats;
        //     }
        // }
        // return ans;
    }
}
// @lc code=end

