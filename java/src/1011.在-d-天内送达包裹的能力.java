/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // 97% 10%  
        int low = 0, high = 0;
        for (int w: weights) {
            if (w > low) low = w;
            high += w;
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            int need = 1, cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need++;
                    cur = 0;
                }
                cur += w;
            }

            if (need <= days) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
// @lc code=end

