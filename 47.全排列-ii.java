import java.awt.List;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        // 通过维护isVisited这个数组来判断哪些数字已经被用过了，这样可以加快速率
        permuteUniqueDfs(res, combine, nums, isVisited,0);
        return res;
    }

    private void permuteUniqueDfs(List<List<Integer>> res, List<Integer> combine, int[] nums, boolean[] isVisited,int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(combine));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]||i>0&&nums[i]==nums[i-1]&&!isVisited[i-1]){
                //这一步的目的是保证第i个位置，数组里重复的数字只会被填入一次
                //首先当i>0的时候，检查nums[i]是否等于nums[i-1]如果等于，说明这是重复的数字
                //然后要判断nums[i-1]是否被填入到目前的组合中过了，如果填入过了，说明这个数在前面被填入过了
                //那么此处再填入就没问题了
                //如果没有被填入过，那就说明再填这个数会重复，就不能再填入了。
                //就要跳过
                continue;
            }
            isVisited[i] = true;
            combine.add(nums[i]);
            permuteUniqueDfs(res, combine, nums, isVisited,idx+1);
            combine.remove(idx);
            isVisited[i] = false;
        }
    }
}
// @lc code=end

