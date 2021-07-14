/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    // 使用了编码的思想
    // 对完全二叉树的每一个节点进行编码
    // 具体来说，根节点编码为1，往左节点走编码为0，往右节点走编码为1
    // 对于一个层数为h的完全二叉树，其包含的节点个数为[2^h,2^(h+1)-1]
    // 所以可以采用二分查找的办法来提高速度
    // 假设第k个节点存在，那么节点个数一定是大于等于k的，如果第k个节点不存在，那么节点个数一定小于k

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        //获取二叉树最大层数h
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // low和high分别表示层数为h的二叉树的节点数量的范围
        // 采用位运算来进行乘方运算，小技巧
        int low = 1 << level, high = (1 << (level + 1)) - 1;
        //二分查找来逼近找到节点的具体数量
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            // 若第mid个节点存在，那么表明节点总数量一定是大于等于mid的
            if (exists(root, level, mid)) {
                low = mid;
            }
            // 若第mid个节点不存在，那么表明节点总数量一定是小于mid的 
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        // bits为全1，位数为level位
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            //根据bits来确定路径，如果是0说明往左走，如果是1就是往右走
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            // 走完一步以后bits向右移动一位
            bits >>= 1;
        }
        // 如果此时节点非空，说明其存在
        return node != null;
    }
}

// @lc code=end

