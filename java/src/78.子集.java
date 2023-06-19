import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<Integer>();
        res.add(tmp);
        dfs(nums, 0, tmp, res);
        return res;
    }

    public void dfs(int[] nums, int cur, List<Integer> path, List<List<Integer>> res) {
        if (cur >= nums.length) return;
        path.add(nums[cur]);
        res.add(new ArrayList<Integer>(path));
        dfs(nums, cur+1, path, res);
        path.remove(path.size() - 1);
        dfs(nums, cur+1, path, res);
        return;
    }
}
// @lc code=end

