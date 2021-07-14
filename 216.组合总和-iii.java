import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ans = new ArrayList<>();
        combinationSum3Helper(k, n, 1, ans);
        return res;
    }

    public void combinationSum3Helper(int k, int n, int sp, List<Integer> ans) {
        if (k == 0 || n == 0) {
            if (k == 0 && n == 0) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }
        for (int i = sp; i <= 9; i++) {
            if (10 - i < k || k * (19 - k) / 2 < n || n - i < 0) {
                break;
            }
            ans.add(i);
            combinationSum3Helper(k - 1, n - i, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
    }
}
// @lc code=end

