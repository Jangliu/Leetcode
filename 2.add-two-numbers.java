import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode Temp = head;
        boolean flag;
        if ((l1.val + l2.val) >= 10) {
            head.val = (l1.val + l2.val) % 10;
            flag = true;
        } else {
            head.val = l1.val + l2.val;
            flag = false;
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (flag) {
                sum += 1;
            }
            if (sum >= 10) {
                flag = true;
                sum = sum % 10;
            } else {
                flag = false;
            }
            ListNode temp = new ListNode(sum);
            Temp.next = temp;
            Temp = Temp.next;
        }
        if (flag) {
            ListNode temp = new ListNode(1);
            Temp.next = temp;
        }
        return head;
    }
}
// @lc code=end

