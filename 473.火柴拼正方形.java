/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 *
 * https://leetcode-cn.com/problems/matchsticks-to-square/description/
 *
 * algorithms
 * Medium (42.11%)
 * Likes:    356
 * Dislikes: 0
 * Total Accepted:    43.5K
 * Total Submissions: 97.7K
 * Testcase Example:  '[1,1,2,2,2]'
 *
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你
 * 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
 * 
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= matchsticks.length <= 15
 * 1 <= matchsticks[i] <= 10^8
 * 
 * 
 */

// @lc code=start

// 回溯算法
import java.util.Arrays;

// class Solution {
//     public boolean makesquare(int[] matchsticks) {
//         int totalLen = Arrays.stream(matchsticks).sum();
//         if (totalLen % 4 != 0) return false;

//         Arrays.sort(matchsticks);
//         for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
//             int temp = matchsticks[i];
//             matchsticks[i] = matchsticks[j];
//             matchsticks[j] = temp;
//         }

//         int[] edges = new int[4];
//         return dfs(0, matchsticks, edges, totalLen/4);
    
//     }

//     private boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
//         if (index == matchsticks.length) {
//             return true;
//         }

//         for (int i = 0; i < edges.length; i++) {
//             edges[i] += matchsticks[index];
//             if (edges[i] <= len && dfs(index+1, matchsticks, edges, len)) {
//                 return true;
//             }
//             edges[i] -= matchsticks[index];

//         }
//         return false;
//     }
// }

// 动态规划

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            return false;
        }
        int len = totalLen / 4, n = matchsticks.length;
        int[] dp = new int[1 << n];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int s = 1; s < (1 << n); s++) {
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) {
                    continue;
                }
                int s1 = s & ~(1 << k);
                if (dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len) {
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }
}


// @lc code=end


