import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=797 lang=java
 *
 * [797] 所有可能的路径
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        stack.offerLast(0);
        dfs(graph, 0, n - 1);
        return ans;
    }

    public void dfs(int[][] g, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(stack));
            return;
        }

        for (int y : g[x]) {
            stack.offerLast(y);
            dfs(g, y, n);
            stack.pollLast();
        }
    }
}
// @lc code=end

