import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
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

    HashMap<String, TreeNode> seen = new HashMap<>();
    HashSet<TreeNode> duplicate = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<TreeNode>(duplicate);
    }

    private String dfs(TreeNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(',');
        sb.append(dfs(node.left));
        sb.append(',');
        sb.append(dfs(node.right));
        String serial = sb.toString();
        if (seen.containsKey(serial)) {
            duplicate.add(seen.get(serial));
        } else {
            seen.put(serial, node);
        }

        return serial;
    }

}
// @lc code=end

