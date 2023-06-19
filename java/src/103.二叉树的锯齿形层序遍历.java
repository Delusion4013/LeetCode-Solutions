import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Deque<TreeNode> s = new LinkedList<>();
        boolean l2r = true;
        s.offer(root);
        while (!s.isEmpty()) {
            Deque<Integer> line = new LinkedList<Integer>();
            int size = s.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = s.poll();
                if (l2r) {
                    line.offerLast(cur.val);
                } else {
                    line.offerFirst(cur.val);
                }
                if (cur.left != null) {
                    s.offer(cur.left);
                }
                if (cur.right != null) {
                    s.offer(cur.right);
                }
            }
            res.add(new LinkedList<Integer>(line));
            l2r = !l2r;
        }
        return res;
    }
}
// @lc code=end

