/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        Integer[] min = { root.val, null };
        inorder(root, min);
        return (min[1] == null) ? -1 : min[1];
    }

    private void inorder(TreeNode root, Integer[] min) {
        if (root == null)
            return;
        if (((root.val != min[0]) && (min[1] == null)) || ((min[0] < root.val) && (root.val < min[1]))) {
            min[1] = root.val;
        } else if (root.val == min[0]) {
            // we need to traverse in this case because node might have a greater child or
            // subchild which could replace second minimum
            inorder(root.left, min);
            inorder(root.right, min);
        }
        /*
         * if node.val >= second minimum, we don't need to traverse further because this
         * node and all the nodes in its subtree will be greater than or equal to second
         * minimum, so we can't find anything less than second minimum.
         */
    }
}
// @lc code=end

