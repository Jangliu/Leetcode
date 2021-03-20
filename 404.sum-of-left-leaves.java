/*
 * @lc app=leetcode id=404 lang=java
 *
 * [404] Sum of Left Leaves
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) // check for left child is leaf
                                                                                    // node?
            return root.left.val + sumOfLeftLeaves(root.right); // Always traverse right sub tree for right tree's left
                                                                // leaf nodes.
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        //吐了，叶子节点是没有左右子节点的那种
    }
}
// @lc code=end

