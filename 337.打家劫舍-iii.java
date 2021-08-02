import jdk.vm.ci.aarch64.AArch64.Flag;

/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    // 用动态规划的办法，只是其中要注意细节
    // 整体思路和前面的robII很像
    public int rob(TreeNode root) {
        return robDfs(root)[0];
    }
    public int[] robDfs(TreeNode root){
        // 这个函数的返回值是一个长度为2的数组
        // 其中下标0代表的是到本节点为止能获得的最大值
        // 其中下标1代表的是到本节点的“前一层”所能获得的最大值
    

        // 因为本题的特殊性，所以需要从叶子节点出发
        // 最后到根节点，获得答案

        // 如果到达叶子节点，那么返回[root.val,0]
        if(root.left==null&&root.right==null){
            return new int[]{root.val,0};
        }
        int [] left={0,0};
        int [] right={0,0};
        // 如果不是叶子节点
        if(root.left!=null){
            left = robDfs(root.left);
        }
        if(root.right!=null){
            right=robDfs(root.right);
        }
        // 到本节点能到达的最大值应该是Max(本节点的值+左右子树前一层能获得的最大值之和，左右子树那一层能获得的最大值之和)

        return new int[]{Math.max(root.val+left[1]+right[1],left[0]+right[0]),left[0]+right[0]};
    }
}
// @lc code=end

