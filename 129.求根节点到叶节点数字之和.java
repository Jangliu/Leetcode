import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return res;
        }
        sumNumbersHelper(root, 0);
        return res;
    }

    public void sumNumbersHelper(TreeNode root, int n) {
        if (root.left == null && root.right == null) {
            res += n * 10 + root.val;
        }
        if (root.left != null) {
            sumNumbersHelper(root.left, n * 10 + root.val);
        }
        if (root.right != null) {
            sumNumbersHelper(root.right, n * 10 + root.val);
        }
    }
}
// @lc code=end

