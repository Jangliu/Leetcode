import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        dfs(0, nums, new ArrayList<>());
        return res;
    }

    public void dfs(int start, int[] nums, List<Integer> combo) {
        if (combo.size() <= nums.length) {
            res.add(new ArrayList<>(combo));
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            combo.add(nums[i]);
            dfs(i + 1, nums, combo);
            combo.remove(combo.size() - 1);
        }
    }
}
// @lc code=end

