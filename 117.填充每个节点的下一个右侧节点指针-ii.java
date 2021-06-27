/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
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
        if (root == null) {
            return null;
        }
        // queue用来存储下一层的所有节点
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            // 遍历当前层的节点的时候就要对当前层节点进行next填充处理
            for (int i = 1; i <= n; ++i) {
                // 取出一个节点
                Node f = queue.poll();
                // 然后将其子节点都再加入到queue中
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                // 如果这个节点不是第一个节点，那么上一个节点的next就是这个节点了
                if (i != 1) {
                    last.next = f;
                }
                // 如果当前处理的节点是这一层的第一个节点，就将其作为头
                last = f;
            }
        }
        return root;
    }
}
// @lc code=end

