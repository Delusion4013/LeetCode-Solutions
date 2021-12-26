/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int bulls = 0;
        int cows = 0;
        int n = secret.length();
        boolean[] isbull = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                isbull[i] = true;
            } else {
                nums[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!isbull[i]) {
                if (nums[guess.charAt(i) - '0'] > 0) {
                    nums[guess.charAt(i) - '0']--;
                    cows++;
                }
            }
        }

        String hint = String.valueOf(bulls) + 'A' + String.valueOf(cows) + 'B';
        return hint;
    }
}
// @lc code=end

