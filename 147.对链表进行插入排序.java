import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    //迭代法来做，其实质为二分排序
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //使用快慢指针来寻找链表的中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //temp为记录的链表中点
        ListNode temp = slow.next;
        slow.next = null;
        //循环迭代对每一半列表都排序
        ListNode left = insertionSortList(head);
        ListNode right = insertionSortList(temp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        //获得排序的两部分列表，然后这两段列表组合起来
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        if (left != null) {
            h.next = left;
        } else {
            h.next = right;
        }
        return res.next;
    }
}
// @lc code=end

