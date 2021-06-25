import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public static boolean isValidBST(TreeNode root) {
        return isValidBSThelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBSThelper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
        // 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
        return isValidBSThelper(node.left, lower, node.val) && isValidBSThelper(node.right, node.val, upper);
    }
}
// @lc code=end

