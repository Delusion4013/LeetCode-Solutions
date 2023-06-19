import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    List<Integer> vals = new ArrayList<>();
    int counter = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inorder(root.left);
        vals.add(root.val);
        if (root.right != null) inorder(root.right);
        return;
    }
    
    public int next() {
        return vals.get(counter++);
    }
    
    public boolean hasNext() {
        return counter < vals.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

