import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=841 lang=java
 *
 * [841] 钥匙和房间
 */

// @lc code=start
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            List<Integer> keys = rooms.get(queue.poll());
            for (int i = 0; i < keys.size(); i++) {
                if (!visited[keys.get(i).intValue()]) {
                    visited[keys.get(i).intValue()] = true;
                    queue.offer(keys.get(i));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) return false;
        }
        return true;
    }
}
// @lc code=end

