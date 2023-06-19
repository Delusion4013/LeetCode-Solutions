/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 99% 90%
        int n = piles.length;
        
        int low = 1, high = 0;
        for (int p : piles) {
            if (p > high) high = p;
        }

        while (low < high) {
            int speed = (high + low) / 2;
            int time = getTime(piles, speed);
            if (time <= h) {
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return low;
    }

    private int getTime(int[] nums, int speed) {
        int time = 0;
        for (int i = 0; i < nums.length; i++) {
            int curTime = (nums[i] + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
// @lc code=end

