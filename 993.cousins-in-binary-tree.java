/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode px = getParentNode(root, x);
        TreeNode py = getParentNode(root, y);
        int dx = getNodeDepth(root, x);
        int dy = getNodeDepth(root, y);
        return px != py && dx == dy;
    }

    public TreeNode getParentNode(TreeNode root, int x) {
        if (root.left != null) {
            if (root.left.val == x) {
                return root;
            }
            if (getParentNode(root.left, x) != null) {
                return getParentNode(root.left, x);
            }
        }
        if (root.right != null) {
            if (root.right.val == x) {
                return root;
            }
            if (getParentNode(root.right, x) != null) {
                return getParentNode(root.right, x);
            }
        }
        return null;
    }

    public int getNodeDepth(TreeNode root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.val == x) {
            return 0;
        }
        if (getNodeDepth(root.left, x) != -1) {
            return 1 + getNodeDepth(root.left, x);
        }
        if (getNodeDepth(root.right, x) != -1) {
            return 1 + getNodeDepth(root.right, x);
        }
        return -1;
    }
}
// @lc code=end

