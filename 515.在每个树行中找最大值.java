import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    List<List<Integer>> res;
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        res = new ArrayList<>();
        largestValuesHelper(root, 1);
        for(List<Integer> list:res){
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
    public void largestValuesHelper(TreeNode root,int index){
        if(index>res.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.MIN_VALUE);
            res.add(temp);
        }
        List<Integer> cur = res.get(index-1);
        int curVal = cur.get(cur.size()-1);
        if(curVal<=root.val){
            cur.add(root.val);
        }
        if(root.left!=null){
            largestValuesHelper(root.left, index+1);
        }
        if(root.right!=null){
            largestValuesHelper(root.right, index + 1);
        }
    }
}
// @lc code=end

