/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
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
        int m = 0, n = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            m++;
            curA = curA.next;
        }
        while (curB != null) {
            n++;
            curB = curB.next;
        }
        ListNode longer, shorter;
        int c=m-n;
        if (c>=0) {
            longer = headA;
            shorter = headB;
        } else {
            longer = headB;
            shorter = headA;
            c=-c;
        }
        for (int i = 0; i < c; i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == shorter) {
                return longer;
            } else {
                longer = longer.next;
                shorter = shorter.next;
            }
        }
        return null;

    }
}
// @lc code=end

