import java.util.LinkedList;
import java.util.Queue;

import javax.naming.LinkException;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q1 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            int curLevelSize = q1.size();
            for (int i = 0; i < curLevelSize; i++) {
                Node tmp = q1.poll();
                if (i < curLevelSize - 1) {
                    tmp.next = q1.peek();
                }
                if (tmp.left != null) {
                    q1.offer(tmp.left);
                }
                if (tmp.right != null) {
                    q1.offer(tmp.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end

