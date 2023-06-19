import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    private void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }

        dfs(false, cur+1, nums);
        if (!choosePre && cur > 0 && nums[cur-1] == nums[cur]) {
            return;
        }
        tmp.add(nums[cur]);
        dfs(true, cur+1, nums);
        tmp.remove(tmp.size()- 1);
    }
}
// @lc code=end

