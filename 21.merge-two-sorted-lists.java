/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode NewList = new ListNode();
        ListNode cur = NewList;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }
            if (l2 == null) {
                cur.next = l1;
                break;
            }
            if (l1.val >= l2.val) {
                ListNode temp = new ListNode(l2.val);
                cur.next = temp;
                cur = cur.next;
                l2 = l2.next;
            } else {
                ListNode temp = new ListNode(l1.val);
                cur.next = temp;
                cur = cur.next;
                l1 = l1.next;
            }
        }
        return NewList.next;
    }
}
// @lc code=end

