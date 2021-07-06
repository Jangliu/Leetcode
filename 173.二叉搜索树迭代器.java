import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    int cur = Integer.MIN_VALUE;
    List<Integer> nums = new ArrayList<>();
    int index=1;
    public BSTIterator(TreeNode root) {
        nums.add(cur);
        BSTIteratorHelper(root);
    }
    
    public int next() {
        return nums.get(index++);
    }
    
    public boolean hasNext() {
        return index<nums.size();
    }
    public void BSTIteratorHelper(TreeNode root){
        if(root.left!=null){
            BSTIteratorHelper(root.left);
        }
        nums.add(root.val);
        if(root.right!=null){
            BSTIteratorHelper(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

