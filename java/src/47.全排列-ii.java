import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }
            
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    
    
    }
}
// @lc code=end

