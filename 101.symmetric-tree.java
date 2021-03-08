/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }
    public static boolean isSym(TreeNode t1,TreeNode t2){
        if(t1==null &&t2==null){
            return true;
        }
        while(t1!= null && t2!=null){
            if(t1.val!=t2.val){
                return false;
            }
            return isSym(t1.left, t2.right) &&isSym(t1.right, t2.left);
        }
        return false;
    }
}
// @lc code=end

