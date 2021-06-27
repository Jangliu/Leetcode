import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }
        List<Integer> ans = new ArrayList<>();
        pathSumHelper(root, targetSum, ans);
        return res;
    }

    public void pathSumHelper(TreeNode root, int targetSum, List<Integer> ans) {
        ans.add(root.val);
        int newTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null && newTargetSum == 0) {
            List<Integer> temp = new ArrayList<>(ans);
            res.add(temp);
            return;
        }
        if (root.left != null) {
            pathSumHelper(root.left, newTargetSum, ans);
            ans.remove(ans.size() - 1);
        }
        if (root.right != null) {
            pathSumHelper(root.right, newTargetSum, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
// @lc code=end

