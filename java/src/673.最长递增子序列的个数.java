import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
       int n = nums.length;
       if (n <= 1) return n;
       int[] lengths = new int[n];
       int[] counts = new int[n];
       Arrays.fill(counts, 1);
       for (int j = 0; j < n; j++) {
           for (int i = 0; i < j; i++) {
               if (nums[j] > nums[i]) {
                   if (lengths[i] >= lengths[j]) {
                       lengths[j] = lengths[i] + 1;
                       counts[j] = counts[i];
                   } else if (lengths[i] + 1 == lengths[j]) {
                       counts[j] += counts[i];
                   }
               }
           }
       }
    //    System.out.println(Arrays.toString(lengths));
    //    System.out.println(Arrays.toString(counts));
       int longest = 0, ans = 0;
       for (int i = 0; i < n; i++) {
           longest = Math.max(lengths[i], longest);
       }
       for (int i = 0; i < n; i++) {
           if (lengths[i] == longest) {
               ans+=counts[i];
           }
       }
       return ans;
    }
}
// @lc code=end

