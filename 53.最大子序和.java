/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -1000001;
        int cur = 0;
        for (int n : nums) {
            cur = Math.max(n, cur + n);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }
}
// @lc code=end

