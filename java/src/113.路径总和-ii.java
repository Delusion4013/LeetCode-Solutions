import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path, 0, targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> path, int sum, int target) {
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        if (root.left != null) {
            path.add(root.val);
            dfs(root.left, path, sum+root.val, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(root.val);
            dfs(root.right, path, sum+root.val, target);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

