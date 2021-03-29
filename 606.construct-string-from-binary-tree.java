import javax.naming.spi.DirStateFactory.Result;

/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = goThroughtree2str(t);
        return result.substring(1, result.length() - 1);
    }

    public static String goThroughtree2str(TreeNode root) {
        String temp = "(" + String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            return temp + ")";
        }
        if (root.left == null && root.right != null) {
            return temp + "()" + goThroughtree2str(root.right) + ")";
        }
        if (root.left != null && root.right == null) {
            return temp + goThroughtree2str(root.left) + ")";
        }
        return temp + goThroughtree2str(root.left) + goThroughtree2str(root.right) + ")";
    }
}
// @lc code=end

