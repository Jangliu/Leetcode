import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int n : nums) {
            numbers.add(n);
        }
        List<Integer> combine = new ArrayList<>();
        permuteDfs(res, combine, numbers);
        return res;

    }

    public static void permuteDfs(List<List<Integer>> res, List<Integer> combine, List<Integer> numbers) {
        if (numbers.size() == 0) {
            List<Integer> path = new ArrayList<>();
            path.addAll(combine);
            res.add(path);
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            combine.add(numbers.get(i));
            List<Integer> temp = new ArrayList<>();
            temp.addAll(numbers);
            temp.remove(i);
            permuteDfs(res, combine, temp);
            combine.remove(combine.size() - 1);
        }
    }
}
// @lc code=end

