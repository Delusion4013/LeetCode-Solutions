import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        // DFS
        // if (root == null) {
        //     return 0;
        // }
        // if (root.left == null && root.right == null) {
        //     return 1;
        // }

        // int min_depth = Integer.MAX_VALUE;
        // if (root.left != null) {
        //     min_depth = Math.min(min_depth, minDepth(root.left));
        // }
        // if (root.right != null) {
        //     min_depth = Math.min(min_depth, minDepth(root.right));
        // }
        // return min_depth + 1;

        // BFS
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                } 
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return 0;
    }
}
// @lc code=end

