import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> val = new ArrayList<>();
        getAllValues(root, val);
        TreeNode result=new TreeNode(val.get(0));
        TreeNode head = result;
        for(int i=1;i<val.size();i++){
            TreeNode temp = new TreeNode(val.get(i));
            head.right=temp;
            head = head.right;
        }
        return result;
    }
    public void getAllValues(TreeNode root,ArrayList<Integer> val){
        if(root.left!=null){
            getAllValues(root.left, val);
        }
        val.add(root.val);
        if(root.right!=null){
            getAllValues(root.right, val);
        }
    }
}
// @lc code=end

