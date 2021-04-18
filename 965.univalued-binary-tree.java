import java.util.HashSet;

/*
 * @lc app=leetcode id=965 lang=java
 *
 * [965] Univalued Binary Tree
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
    public boolean isUnivalTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        set.add(root.val);
        return checkValues(root.left, set)&&checkValues(root.right, set);
    }
    public static boolean checkValues(TreeNode root,HashSet<Integer> set){
        if(root==null){
            return true;
        }
        if(set.contains(root.val)){
            return checkValues(root.left, set)&&checkValues(root.right, set);
        }
        return false;
    }
}
// @lc code=end

