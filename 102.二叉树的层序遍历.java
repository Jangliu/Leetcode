import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        int level = 0;
        levelOrderHelper(root, level);
        return ans;
    }

    public void levelOrderHelper(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        if (ans.size() < n + 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            ans.add(temp);
        } else {
            ans.get(n).add(root.val);
        }
        if (root.left != null) {
            levelOrderHelper(root.left, n + 1);
        }
        if (root.right != null) {
            levelOrderHelper(root.right, n + 1);
        }
    }
}
// @lc code=end

