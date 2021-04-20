/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    public int sumRootToLeaf(TreeNode root) {
        return valRootToLeaf(root,0);
    }
    public int valRootToLeaf(TreeNode root,int val){
        if(root.left==null&&root.right==null){
            return root.val+2*val;
        }
        val=2*val+root.val;
        int left=0;
        if(root.left!=null){
            left = valRootToLeaf(root.left,val);
        }
        int right = 0;
        if (root.right != null) {
            right = valRootToLeaf(root.right,val);
        }
        return left+right;
    }
}
// @lc code=end

