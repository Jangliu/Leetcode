import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        //通过维护isVisited这个数组来判断哪些数字已经被用过了，这样可以加快速率
        permuteDfs(list, temp, nums, isVisited);
        return list;
    }

    private void permuteDfs(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] isVisited) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i])
                continue;
            isVisited[i] = true;
            temp.add(nums[i]);
            permuteDfs(list, temp, nums, isVisited);
            temp.remove(temp.size() - 1);
            isVisited[i] = false;
        }
    }
}
// @lc code=end

