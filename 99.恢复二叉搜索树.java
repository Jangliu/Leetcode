import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    TreeNode pre, wrong01, wrong02;

    public void recoverTree(TreeNode root) {
        inorder(root);

        int temp = wrong01.val;
        wrong01.val = wrong02.val;
        wrong02.val = temp;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);

        // 我们要找出错误的两个节点

        if (pre == null) {
            // 如果是第一个节点
            pre = root;
        } else {
            if (root.val > pre.val) {
                // 如果当前节点大于前一个节点, 直接遍历下一个节点
                pre = root;
            } else {
                // 当前节点小于前一个节点
                if (wrong01 == null) {
                    // 第一次发生错误
                    wrong01 = pre;
                    wrong02 = root;
                    pre = root;
                } else {
                    // 找到第二个错误位置, 后面就不用遍历了
                    wrong02 = root;
                    return;
                }
            }
        }

        inorder(root.right);
    }
}

// @lc code=end

