import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1619 lang=java
 *
 * [1619] 删除某些元素后的数组均值
 */

// @lc code=start
class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int trim = (int) (n * 0.05);
        // System.out.println(trim);
        double ans = 0.0;
        for (int i = trim; i < n-trim; i++) {
            ans += arr[i];
        }

        return ans/(n-2*trim);

    }
}
// @lc code=end

