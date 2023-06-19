import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (len == 0) return ans;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, ans);
        return ans;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> ans) {
        if (depth == len) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth+1, path, used, ans);
                used[i] = false;
                path.remove(path.size() - 1);

            }
        }
    }
}
// @lc code=end

