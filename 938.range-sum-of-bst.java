/*
 * @lc app=leetcode id=938 lang=java
 *
 * [938] Range Sum of BST
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
    //BST每一个节点的值大于其任意左侧子节点的值，小于其任意右节点的值。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        if(root.val>=low &&root.val<=high){
            return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right, low, high);
        }
        if(root.val>high){
            return rangeSumBST(root.left, low, high);
        }
        return rangeSumBST(root.right, low, high);
    }
}
// @lc code=end

