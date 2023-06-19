import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
// class Solution {
//     public int bulbSwitch(int n) {
//         boolean[] bulbs = new boolean[n];
//         for (int i = 1; i <= n; i++) {
//             int s = i-1;
//             while(s < n) {
//                 bulbs[s] = !bulbs[s];
//                 s += i;
//             }
//             //System.out.println(Arrays.toString(bulbs));
//         }
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             if (bulbs[i]) {
//                 res++;
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }
}

// @lc code=end

