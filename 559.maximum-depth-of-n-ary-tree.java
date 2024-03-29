/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
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
    public int maxDepth(Node root) {
        if(root !=null){
            int max = 0;
            for(int i=0;i<root.children.size();i++){
                max = Math.max(max,maxDepth(root.children.get(i)));
            }
            return 1+max;
        }
        return 0;
    }
}
// @lc code=end

