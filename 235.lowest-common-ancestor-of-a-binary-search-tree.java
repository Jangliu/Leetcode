import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q){
            return root;
        }
        if(isDescendants(root.left, p)){
            if(isDescendants(root.right, q)){
                return root;
            }
            else{
                return lowestCommonAncestor(root.left, p, q);
            }
        }
        if (isDescendants(root.left, q)) {
            if (isDescendants(root.right, p)) {
                return root;
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        }
        return lowestCommonAncestor(root.right, p, q);
    }
    public static boolean isDescendants(TreeNode root,TreeNode p){
        if(root==p||root==p){
            return true;
        }
        else{
             boolean l=false;
             boolean r =false;
             if(root.left!=null){
                 l=isDescendants(root.left, p);
             }
             if(root.right!=null){
                 r=isDescendants(root.right, p);
             }
             return l||r;
        }
    }
}
// @lc code=end

