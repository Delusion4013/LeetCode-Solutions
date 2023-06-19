/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) return newNode;
        else if (root.left == null && root.right == null) {
            if (root.val > val) {
                root.left = newNode;
                return root;
            } else {
                root.right = newNode;
                return root;
            }
        } else {
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
                return root;
            } else {
                root.right = insertIntoBST(root.right, val);
                return root;
            }
        }

        // if (val < root.val) {
        //     root.left = insertIntoBST(root.left, val);
        // } else {
        //     root.right = insertIntoBST(root.right, val);
        // }
        // return root;
    }
}
// @lc code=end

