/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res = 0;
        int lastMax = 0;
        res = Math.max(nums[0], nums[1]);
        lastMax = nums[0];
        for (int i = 2; i < nums.length; i++) {
            nums[i] += lastMax;
            res = Math.max(res, nums[i]);
            lastMax = Math.max(lastMax, nums[i - 1]);
        }
        return res;
    }
}
// @lc code=end

