import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> val1=new ArrayList<>();
        ArrayList<Integer> val2 = new ArrayList<>();
        val1=getValues(root1, val1);
        val2 = getValues(root2, val2);
        return val1.equals(val2);
    }
    public ArrayList<Integer> getValues(TreeNode root,ArrayList<Integer> result){
        if(root.left==null&&root.right==null){
            result.add(root.val);
            return result;
        }
        if(root.left!=null){
            result = getValues(root.left, result);
        }
        if(root.right!=null){
            result=getValues(root.right, result);
        }
        return result;
    }
}
// @lc code=end

