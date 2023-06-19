import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
        
        // Hash Set
        // Set<ListNode> nodes = new HashSet<ListNode>();
        // ListNode temp = headA;

        // while (temp != null) {
        //     nodes.add(temp);
        //     temp = temp.next;
        // }
        // temp = headB;
        // while (temp != null) {
        //     if (nodes.contains(temp)) {
        //         return temp;
        //     }
        //     temp = temp.next;
        // }
        // return null;
    }
}
// @lc code=end

