/*
 * @lc app=leetcode.cn id=396 lang=java
 *
 * [396] 旋转函数
 */

// @lc code=start
class Solution {
    public int maxRotateFunction(int[] nums) {
        int res = 0;
        // 记录nums数组的总和
        int sum = 0;
        int F = 0;
        // 辅助用来计算F0；
        int index = 0;
        for (int n : nums) {
            sum += n;
            F += index * n;
            index++;
        }
        res = F;
        for (int i = 1; i < nums.length; i++) {
            F = F - (sum - nums.length * nums[i - 1]);
            res = Math.max(res, F);
        }
        return res;
    }
}
// @lc code=end

