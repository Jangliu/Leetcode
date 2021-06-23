import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            subsetDfs(nums, 0, nums.length, i);
        }
        return res;
    }

    public void subsetDfs(int[] nums, int cur, int n, int k) {
        // 剪枝：ans 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if ((ans.size() + (n - cur + 1) < k) || cur == n) {
            if (ans.size() == k) {
                res.add(new ArrayList<Integer>(ans));
                return;
            }
            return;
        }
        // 记录合法的答案
        if (ans.size() == k) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        // 考虑选择当前位置,即将当前位置加入ans然后再递归
        ans.add(nums[cur]);
        subsetDfs(nums, cur + 1, n, k);
        ans.remove(ans.size() - 1);
        // 考虑不选择当前位置，即跳过当前位置，考虑下一位
        subsetDfs(nums, cur + 1, n, k);
    }
}
// @lc code=end

