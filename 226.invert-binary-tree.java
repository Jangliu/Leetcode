import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        if(root.left!=null&&root.right!=null){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
        if(root.left==null &&root.right!=null){
            root.left = root.right;
            root.right=null;
            invertTree(root.left);
            return root;
        }
        if (root.right == null && root.left != null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
            return root;
        }
        return root;
    }
}
// @lc code=end

