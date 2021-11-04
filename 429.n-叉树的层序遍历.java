import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
    List<List<Integer>> levelOrderRes;
    public List<List<Integer>> levelOrder(Node root) {
        levelOrderRes = new ArrayList<>();
        if(root!=null){
            levelOrderDfs(root, 1);
        }
        return levelOrderRes;
    }
    public void levelOrderDfs(Node root,int level){
        if(levelOrderRes.size()<level){
            levelOrderRes.add(new ArrayList<>());
        }
        levelOrderRes.get(level - 1).add(root.val);
        for(Node child:root.children){
            levelOrderDfs(child, level+1);
        }
    }
}
// @lc code=end

