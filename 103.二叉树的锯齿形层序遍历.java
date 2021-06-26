/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = 0;
        // flag为true代表从左到右
        boolean flag = true;
        zigzagLevelOrderHelper(root, level, flag);
        return ans;
    }

    public void zigzagLevelOrderHelper(TreeNode root, int n, Boolean flag) {
        if (root == null) {
            return;
        }
        if (ans.size() < n + 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            ans.add(temp);
        } else {
            if (flag) {
                ans.get(n).add(root.val);
            } else {
                ans.get(n).add(0, root.val);
            }
        }
        if (root.left != null) {
            zigzagLevelOrderHelper(root.left, n + 1, !flag);
        }
        if (root.right != null) {
            zigzagLevelOrderHelper(root.right, n + 1, !flag);
        }
    }
}
// @lc code=end

