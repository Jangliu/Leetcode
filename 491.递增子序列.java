import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesDfs(0, Integer.MIN_VALUE, nums);
        return ans;
    }

    public void findSubsequencesDfs(int cur, int last, int[] nums) {
        if (cur == nums.length) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        if (nums[cur] >= last) {
            temp.add(nums[cur]);
            findSubsequencesDfs(cur + 1, nums[cur], nums);
            temp.remove(temp.size() - 1);
        }
        // 这一步可以确保跳过.....5,5,5,5,5.....这样连续的相同数字
        if (nums[cur] != last) {
            findSubsequencesDfs(cur + 1, last, nums);
        }
    }
}

// @lc code=end

