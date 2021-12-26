/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-101, head);
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            if (cur.val == prev.val) {
                ListNode next = cur.next;
                prev.next = cur.next;
                cur = next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

