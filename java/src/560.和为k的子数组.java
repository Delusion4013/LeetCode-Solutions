import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;

        
        // Brute Force
        // int n = nums.length;
        // int[] pre = new int[n+1];
        // int res = 0;
        // pre[0] = 0;
        // for (int i = 1; i <= nums.length; i++) {
        //     pre[i] = pre[i-1] + nums[i-1];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j <= nums.length; j++) {
        //         if (pre[j] - pre[i] == k) {
        //             res++;
        //         }
        //     }
        // }
        // return res;
    }
}
// @lc code=end

