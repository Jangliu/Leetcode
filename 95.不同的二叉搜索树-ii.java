import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateBinarySearchTrees(1, n);
    }

    public List<TreeNode> generateBinarySearchTrees(int start, int end) {
        // 返回数值在[start,end]这个范围内的二叉搜索树
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            // 这里要增加一个null的原因是，当执行到最末端的叶子节点时
            // 对于每一个叶子节点，其左子树为Null,右子树也为null
            // 这样才能对于该叶子节点遍历左右子树生成叶子节点
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得对于该根节点的所有可行的左子树集合
            List<TreeNode> leftTrees = generateBinarySearchTrees(start, i - 1);

            // 获得对于该根节点的所有可行的右子树集合
            List<TreeNode> rightTrees = generateBinarySearchTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
// @lc code=end

