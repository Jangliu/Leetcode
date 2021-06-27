import java.util.ArrayList;

import org.graalvm.compiler.lir.LIRInstruction.Temp;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //思路如下：
        //第0层只有一个节点，不用操作
        //第1层有两个节点，只需要通过第0层将这两个节点连接起来即可
        //第2层有4个节点，分属于两个父节点
        //对于同一个父节点的两个节点来说，只需要简单地连接起来即可
        //对于不同父节点的两个节点来说，由于父节点已经是连接好了的，所以移动一下父节点即可
        //所以每当遍历到N层时，实际上N层的节点都已连接好了，N层是在连接N+层的节点
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }
}
// @lc code=end

