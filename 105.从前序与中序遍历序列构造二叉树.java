import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return mybuild(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode mybuild(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int preorder_root = preStart;
        int inorder_root = map.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_tree = inorder_root - inStart;
        root.left = mybuild(preorder, inorder, preStart+1, preStart+size_left_tree, inStart, inorder_root-1);
        root.right = mybuild(preorder, inorder, preStart+size_left_tree+1, preEnd, inorder_root+1, inEnd);
        return root;
    }

    
}
// @lc code=end

