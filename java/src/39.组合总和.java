import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> comb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, 0, comb, ans);

        return ans;
    }

    public void backtrack(int[] candidates, int sum, int target, int begin, List<Integer> comb, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {
                comb.add(candidates[i]);
                backtrack(candidates, sum+candidates[i], target, i, comb, ans);
                comb.remove(comb.size()-1);
            } else {
                break;
            }
        }
    
    }



}
// @lc code=end

