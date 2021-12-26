import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1823 lang=java
 *
 * [1823] 找出游戏的获胜者
 */

// @lc code=start
class Solution {
    public int findTheWinner(int n, int k) {
        Deque<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int cur = 1;
        while (q.size() > 1) {
            if (cur % k != 0) {
                q.addLast(q.removeFirst());
            } else {
                q.removeFirst();
            }
            cur++;
        }
        return q.poll();
    }
}
// @lc code=end

