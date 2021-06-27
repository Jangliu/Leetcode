import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                //当前节点非空时
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                // 找到当前节点的左子树中最右的那个节点
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                //将当前节点的右子树放到找到的左子树中最右节点的右子树上
                predecessor.right = curr.right;
                //当前节点的左子树置为空
                //把next置为当前节点的右子树
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
// @lc code=end

