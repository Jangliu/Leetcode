/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next ==null){
            return head;
        }
        ListNode nhead = head;
        ListNode temp;
        while(head.next!=null){
            temp = head.next;
            head.next=temp.next;
            temp.next=nhead;
            nhead=temp;
        }
        return nhead;
    }
}
// @lc code=end

