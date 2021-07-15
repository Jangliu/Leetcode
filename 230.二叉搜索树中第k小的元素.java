import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
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
    // 用栈来进行迭代，加快速度
  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

    while (true) {
        // 将所有“左”节点都加入到栈中
      while (root != null) {
        stack.add(root);
        root = root.left;
      }
      // 如果找到了第K小的元素，即返回
      root = stack.removeLast();
      if (--k == 0) return root.val;
      //换到“右”节点继续寻找
      root = root.right;
    }
  }
}

// @lc code=end

