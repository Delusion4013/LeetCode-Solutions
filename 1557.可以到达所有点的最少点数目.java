import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1557 lang=java
 *
 * [1557] 可以到达所有点的最少点数目
 */

// @lc code=start
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> in = new HashSet<>();
        Set<Integer> a = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            if (!a.contains(edge.get(0))) {
                in.add(edge.get(0));
            }
            a.add(edge.get(1));
            if (in.contains(edge.get(1))) {
                in.remove(edge.get(1));
            }
        }
        List<Integer> res = new ArrayList<>(in);
        
        return res;

    }
}
// @lc code=end

