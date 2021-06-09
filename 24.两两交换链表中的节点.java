/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        int[] val=new int[100];
        int len=0;
        while(head!=null){
            val[len]=head.val;
            head=head.next;
            len++;
        }
        for(int i=0;i<len-1;i+=2){
            int temp=val[i+1];
            val[i+1]=val[i];
            val[i]=temp;
        }
        if(len==0){
            return null;
        }
        ListNode res = new ListNode(val[0]);
        ListNode cur = res;
        for(int i=1;i<len;i++){
            ListNode t = new ListNode(val[i]);
            cur.next=t;
            cur=cur.next;
        }
        return res;
    }
}
// @lc code=end

