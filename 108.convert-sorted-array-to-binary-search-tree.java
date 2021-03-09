import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode();
        createBST(root, 0, nums.length-1, nums);
        return root;
    }
    public static void createBST(TreeNode root,int sp,int ep,int[] nums){
        switch(ep-sp){
            case 1:
                root.val = Math.max(nums[sp], nums[ep]);
                root.left = new TreeNode(Math.min(nums[sp], nums[ep]));
                return;
            case 0:
                root.val = nums[sp];
                return;
            default:
                root.val = nums[(ep + sp) / 2];
                TreeNode left = new TreeNode();
                root.left = left;
                TreeNode right = new TreeNode();
                root.right = right;
                createBST(left, sp, (sp + ep) / 2 - 1, nums);
                createBST(right, (sp + ep) / 2 + 1, ep, nums);

        }
    }
    
}
// @lc code=end

