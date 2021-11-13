import java.lang.annotation.Target;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=462 lang=java
 *
 * [462] 最少移动次数使数组元素相等 II
 */

// @lc code=start
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int N = nums.length - 1;
        int res = 0;
        while (i < N) {
            res += nums[N--] - nums[i++];
        }
        return res;
    }
}
// @lc code=end

