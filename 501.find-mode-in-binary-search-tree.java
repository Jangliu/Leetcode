import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        addIntoMap(root);
        int maxCount = 0;
        for(int key:map.keySet()){
            if(map.get(key) >= maxCount){
                maxCount = map.get(key);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
                r.add(key);
            }
        }
        int[] result = new int[r.size()];
        for(int i=0;i<r.size();i++){
            result[i]=r.get(i);
        }
        return result;

    }
    public void addIntoMap(TreeNode root){
        if(map.containsKey(root.val)){
            map.replace(root.val, map.get(root.val)+1);
        }
        else{
            map.put(root.val, 1);
        }
        if(root.left!=null){
            addIntoMap(root.left);
        }
        if(root.right!= null){
            addIntoMap(root.right);
        }
    }
}
// @lc code=end

