import java.util.Arrays;
/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int left = 0, right = people.length-1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        return ans;
    }
}
// @lc code=end

