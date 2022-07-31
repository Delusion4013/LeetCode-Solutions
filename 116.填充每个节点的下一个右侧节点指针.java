import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
        // Single Traversal
        if(root == null) return root;
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node l, Node r) {
        if (l == null || r == null) return;

        l.next = r;
        traverse(l.left, l.right);
        traverse(l.right, r.left);
        traverse(r.left, r.right);
    }
}

// class Solution {
    // public Node connect(Node root) {
    // Single queue
        // if (root == null) return root;
        // Queue<Node> queue1 = new LinkedList<>();
        // queue1.offer(root);
        // while (!queue1.isEmpty()) {
        //     int curLevelSize = queue1.size();
        //     for (int i = 0; i < curLevelSize; i++) {
        //         Node tmp = queue1.poll();
        //         if (i < curLevelSize - 1) {
        //             tmp.next = queue1.peek();
        //         }
        //         if (tmp.left != null) {
        //             queue1.offer(tmp.left);
        //             queue1.offer(tmp.right);
        //         }
                
        //     }
        // }
        // return root;
//     }
// }


// class Solution_doubleQueue {
//     public Node connect(Node root) {
//         if (root == null) return root;
//         Queue<Node> queue1 = new LinkedList<>();
//         Queue<Node> queue2 = new LinkedList<>();
//         queue1.offer(root);
//         while (!queue1.isEmpty()) {
//             int curLevelSize = queue1.size();
//             for (int i = 0; i < curLevelSize; i++) {
//                 Node tmp = queue1.poll();
//                 queue2.offer(tmp);
//                 tmp.next = queue1.peek();
//             }
//             for (int i = 0; i < curLevelSize; i++) {
//                 Node tmp = queue2.poll();
//                 if (tmp.left == null) break;
//                 queue1.offer(tmp.left);
//                 queue1.offer(tmp.right);
//             }
//         }
//         return root;
//     }
// }
// @lc code=end

