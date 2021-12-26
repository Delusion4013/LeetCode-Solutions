/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left != null && root.right != null) {
            TreeNode tmp = invertTree(root.left);
            root.left = invertTree(root.right);
            root.right = tmp;
        }
        else if (root.left == null && root.right != null) {
            TreeNode tmp = invertTree(root.right);
            root.left = tmp;
            root.right = null;
        }
        else if (root.left != null && root.right == null) {
            root.right = invertTree(root.left);
            root.left = null;
        }
        return root;
        
        // A simplified version
        // if (root == null) return root;
        // TreeNode left = invertTree(root.left);
        // TreeNode right = invertTree(root.right);
        // root.left = right;
        // root.right = left;
        // return root;
    }
}
// @lc code=end

