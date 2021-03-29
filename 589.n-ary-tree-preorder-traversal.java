import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        goThrough(root, result);
        return result;
    }

    public void goThrough(Node node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        for (Node n : node.children)
            goThrough(n, result);
    }
}
// @lc code=end

