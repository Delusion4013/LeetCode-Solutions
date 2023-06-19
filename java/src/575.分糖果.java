import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int maxN = n / 2;
        Set<Integer> type = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (type.size() >= maxN) {
                break;
            }
            if (!type.contains(candyType[i])) {
                type.add(candyType[i]);
            }
        }

        return type.size();
    }
}
// @lc code=end

