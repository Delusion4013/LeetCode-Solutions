import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(true) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    
    }
    /* DFS
    List<Integer> tree = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return tree.get(k-1);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorder(root.left);
        tree.add(root.val);
        if (root.right != null) inorder(root.right);
        return;
    }

    */
}
// @lc code=end

