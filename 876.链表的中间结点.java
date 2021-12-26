/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    public ListNode middleNode(ListNode head) {
        double n = 0;
        ListNode tmp = head;
        while (tmp.next != null) {
            n++;
            tmp = tmp.next;
        }
        double mid = Math.ceil(n / 2);
        ListNode res = head;
        for (int i = 0; i < mid; i++) {
            res = res.next;
        }
        return res;
    }
}
// @lc code=end

