import java.util.List;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        goThrough(root, result);
        return result;
    }
    
    public void goThrough(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.children == null) {
            result.add(node.val);
            return;
        }
        for (Node n : node.children) {
            goThrough(n, result);
        }
        result.add(node.val);
    }
}
// @lc code=end

