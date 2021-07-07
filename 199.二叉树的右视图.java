import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        List<Integer> left = rightSideView(root.left);
        List<Integer> right = rightSideView(root.right);
        int i = 0;
        if (right != null) {
            for (; i < right.size(); i++) {
                res.add(right.get(i));
            }
        }
        if (left != null) {
            for (; i < left.size(); i++) {
                res.add(left.get(i));
            }
            return res;
        }
        return res;
    }
}
// @lc code=end

