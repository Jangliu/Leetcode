import java.util.ArrayList;

/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
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
    public int minDiffInBST(TreeNode root) {
        /*
         * okay, we all know that inorder of BST will always gives Sorted order and
         * hence the minimum difference will always be difference between two
         * consecutive elements in inorder
         */
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            ans = Math.min(ans, list.get(i + 1) - list.get(i));
        }
        return ans;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        // 因为是二叉搜索树，所以大小顺序是有规律的，就不需要再自己排一遍。节约时间
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
// @lc code=end

