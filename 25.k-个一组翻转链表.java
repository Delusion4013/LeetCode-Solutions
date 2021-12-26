/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) return dummy.next;
            }
            ListNode nex = tail.next;
            ListNode[] rev = reverseList(head, tail);
            head = rev[0];
            tail = rev[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next; 
        }
        return dummy.next;
    }

    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[] {tail, head};
    }
}
// @lc code=end

