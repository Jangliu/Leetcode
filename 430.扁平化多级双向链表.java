import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        flattenDfs(head);
        return head;
    }
    public Node flattenDfs(Node cur){
        Node oriNext = cur.next;
        Node child = cur.child;
        if (child != null) {
            cur.next = child;
            child.prev = cur;
            cur.child = null;
            cur = flattenDfs(child);
        }

        if (oriNext != null) {
            cur.next = oriNext;
            oriNext.prev = cur;
            cur = flattenDfs(oriNext);
        }
        return cur;
    }
}
// @lc code=end

