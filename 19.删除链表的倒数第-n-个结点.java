import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //只用了一遍遍历，其他快速的答案似乎都是用的两遍遍历
        int len = 0;
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
            len++;
        }
        if (n == len) {
            if (nodes.size() >= 2) {
                return nodes.get(1);
            }
            return null;
        }
        if (n == 1) {
            nodes.get(nodes.size() - 2).next = null;
            return nodes.get(0);
        }
        nodes.get(nodes.size() - 1 - n).next = nodes.get(nodes.size() - n + 1);
        return nodes.get(0);
    }
}
// @lc code=end

