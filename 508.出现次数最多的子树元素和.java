import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    Map<Integer, Integer> map = new HashMap();
    int max = 0;
    List<Integer> res = new ArrayList();

    public int[] findFrequentTreeSum(TreeNode root) {
        // Write your code here
        if (root == null){
            return new int[0];
        }

        helper(root);

        int[] ans = new int[res.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int left = helper(root.left);

        int right = helper(root.right);

        int sum = root.val + left + right;

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int fre = map.get(sum);

        if (fre > max) {
            max = fre;
            res.clear();

            res.add(sum);
        } else if (fre == max) {
            res.add(sum);
        }

        return sum;
    }
}

// @lc code=end

