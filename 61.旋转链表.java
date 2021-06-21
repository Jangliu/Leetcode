import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        // 将链表闭合成一个环，然后再找到一个位置断开即可
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        // 统计链表的长度
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        // add是要移动的位数
        int add = n - k % n;
        if (add == n) {
            return head;
        }
        // 将链表闭合成环
        iter.next = head;
        // 找到要断开的位置
        while (add-- > 0) {
            iter = iter.next;
        }
        // 找到新的头部
        ListNode ret = iter.next;
        // 断开
        iter.next = null;
        return ret;
    }
}
// @lc code=end

