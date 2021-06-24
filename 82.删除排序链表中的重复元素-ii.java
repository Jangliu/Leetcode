import java.util.ArrayList;
import java.util.List;

import jdk.internal.org.jline.terminal.impl.DumbTerminal;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res;
        int headVal = head.val;
        if (head.next.val != headVal) {
            res = head;
            res.next = deleteDuplicates(head.next);
        } else {
            while (head != null) {
                if (head.val == headVal) {
                    head = head.next;
                } else {
                    break;
                }
            }
            res = deleteDuplicates(head);
        }
        return res;
    }
}
// @lc code=end

