/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sp = 0, ep = 0;
        int sum = nums[0];
        int res = Integer.MAX_VALUE;
        while (ep < nums.length) {
            if (sum < target) {
                ep++;
                if (ep < nums.length) {
                    sum += nums[ep];
                } else {
                    break;
                }
                if (nums[ep] >= target) {
                    return 1;
                }
            } else {
                res = Math.min(res, ep - sp + 1);
                sum -= nums[sp];
                sp++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
// @lc code=end

