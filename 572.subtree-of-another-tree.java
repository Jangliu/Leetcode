/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        if(isEqualTree(s, t)){
            return true;
        }
        else{
            return isSubtree(s.left, t)||isSubtree(s.right, t);
        }
    }
    public static boolean isEqualTree(TreeNode s,TreeNode t){
        if(s.val==t.val){
            if(s.left==null &&s.right==null){
                if(t.left==null && t.right==null){
                    return true;
                }
                else{
                    return false;
                }
            }
            if(s.left==null &&s.right!=null){
                if(t.left==null &&t.right!=null){
                    return isEqualTree(s.right, t.right);
                }
                else{
                    return false;
                }
            }
            if(s.left!=null && s.right==null){
                if(t.left!=null && t.right==null){
                    return isEqualTree(s.left, t.left);
                }
                else{
                    return false;
                }
            }
            else{
                if(t.left!=null&&t.right!=null){
                    return isEqualTree(s.right, t.right) && isEqualTree(s.left, t.left);
                }
                else{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }
}
// @lc code=end

