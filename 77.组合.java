import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        combineDfs(1, n, k);
        return ans;
    }

    public void combineDfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置,即将当前位置加入temp然后再递归
        temp.add(cur);
        combineDfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置，即跳过当前位置，考虑下一位
        combineDfs(cur + 1, n, k);
    }
}

// @lc code=end

