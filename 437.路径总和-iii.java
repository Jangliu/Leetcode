/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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
    HashMap<Integer, Integer> cnt;
    public int pathSum(TreeNode root, int targetSum) {
        // 前缀和思路
        // 节点的前缀和为：由根结点到当前结点的路径上所有节点的和
        // 利用先序遍历二叉树，记录下根节点 root到当前节点 p 的路径上除当前节点以外所有节点的前缀和
        // 在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 cur减去 targetSum。
        cnt = new HashMap<>();
        cnt.put(0, 1);
        return pathSumDfs(root,targetSum, 0);
    }

    private int pathSumDfs(TreeNode x, int targetSum, int curSum) {
        if (x == null){
            return 0;
        }
        int ans = 0;
        curSum = curSum + x.val;
        ans = ans + cnt.getOrDefault(curSum - targetSum, 0);
        cnt.put(curSum, cnt.getOrDefault(curSum, 0) + 1);
        ans = ans + pathSumDfs(x.left, targetSum, curSum) + pathSumDfs(x.right,targetSum, curSum);
        cnt.put(curSum, cnt.get(curSum) - 1);
        return ans;
    }
}
// @lc code=end

