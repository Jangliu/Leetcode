import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //快慢指针
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //设置一个快指针，每次走两步
        //设置一个慢指针，每次走一步
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            //当快慢指针第一次相遇的时候这个时候慢指针一定没有走完一圈（数学推导见官方题解）
            //此时再用一个指针ptr，和slow一起每次都只走一步，这样他们一定会在入环点相遇
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

// @lc code=end

