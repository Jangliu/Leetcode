/*
 * @lc app=leetcode id=563 lang=java
 *
 * [563] Binary Tree Tilt
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
    public int findTilt(TreeNode root) {
        root=updateVal(root);
        return goThrough(root);
        
    }
    public static int countVal(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+countVal(root.left)+countVal(root.right);
    }
    public static TreeNode updateVal(TreeNode root){
        if(root==null){
            return root;
        }
        root.val = Math.abs(countVal(root.left) - countVal(root.right));
        if (root.left != null) {
            updateVal(root.left);
        }
        if (root.right != null) {
            updateVal(root.right);
        }
        return root;
    }
    public static int goThrough(TreeNode root){
        if(root!=null){
            return root.val+goThrough(root.left)+goThrough(root.right);
        }
        return 0;
    }
}
// @lc code=end

