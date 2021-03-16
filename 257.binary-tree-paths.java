import java.util.ArrayList;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        String temp = String.valueOf(root.val);
        if (root.left != null) {
            List<String> left = new ArrayList<String>();
            left = binaryTreePaths(root.left);
            for (int i = 0; i < left.size(); i++) {
                paths.add(temp + "->" + left.get(i));
            }
        }
        if (root.right != null) {
            List<String> right = new ArrayList<String>();
            right = binaryTreePaths(root.right);
            for (int i = 0; i < right.size(); i++) {
                paths.add(temp + "->" + right.get(i));
            }
        }
        if (paths.isEmpty()) {
            paths.add(temp);
        }
        return paths;
    }
}
// @lc code=end

