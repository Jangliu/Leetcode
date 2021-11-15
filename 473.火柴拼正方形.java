import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        // 对nums排序，优先放置更长的火柴
        Arrays.sort(nums);
        // 正方形一共四条边，如果这些火柴可以构成正方形，则任意一根火柴必被放入其中一条边
        return makesquareDfs(nums, new int[4], nums.length - 1, sum / 4);
    }

    private boolean makesquareDfs(int[] nums, int[] sums, int index, int target) {
        if (index == -1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            // 如果把火柴放入第i条边超出了边长，或者第i组和第i-1组当前长度相同，如果i>0，那么说明这种情况已经遍历过了
            if ((sums[i] + nums[index] > target) || (i > 0 && sums[i] == sums[i - 1])) {
                continue;
            }
            // 将火柴放入本组
            sums[i] += nums[index];
            // 如果能构成正方形
            if (makesquareDfs(nums, sums, index - 1, target)) {
                return true;
            }
            // 将火柴拿出
            sums[i] -= nums[index];
        }
        return false;
    }
}

// @lc code=end

