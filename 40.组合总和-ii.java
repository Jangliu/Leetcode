/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        backtrack(path, candidates, target, 0, 0);
        return res;
    }

    private void backtrack(List<Integer> path, int[] candidates, int target, int sum, int begin) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1])
            //使用下标来标识就能排除掉重复的答案
            //其原理是，当非开始位遇到连续的重复数字时就会导致重复
                continue;
            int rs = candidates[i] + sum;
            if (rs <= target) {
                path.add(candidates[i]);
                backtrack(path, candidates, target, rs, i + 1);
                //每次尝试添加的时候无论是否成功都把添加到path里的最后一个数字删掉
                //这样就不用每次都申请空间了，节约空间
                //理论上说能节约，但是实际感觉很有限
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }
    }
}
// @lc code=end

