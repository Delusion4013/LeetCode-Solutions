import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length(), maxw = 0;
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        Set<String> set = new HashSet<>();
        for (String str: wordDict) {
            set.add(str);
            maxw = Math.max(maxw, str.length());
        }
        for (int i = 1; i <= len; i++) {
            // 如果分割点 j 到 i 的长度已经大于字典列表里最长的单词的长度，那么就结束枚举
            for (int j = i-1; j >= 0 && j >= i - maxw; j--) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
// @lc code=end

