/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // sum-reg-reg=sum-2*neg=target
        // neg = (sum-target)/2
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        // 定义二维数组dp,其中dp[i][j]表示数组nums的前i个数中选取元素，这些元素之和为j的方案数
        // 数组nums的长度为n，则最终答案为dp[n][neg]
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        // dp[0][j]=1,j==0;dp[0][j]=0,j!=0
        dp[0][0] = 1;
        // 对数组从下标1开始遍历,设数组的第i个元素为num,遍历j
        // 计算dp[i][j]
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                // 如果j<num，则不能选num,此时dp[i][j] = dp[i - 1][j]
                dp[i][j] = dp[i - 1][j];
                // 否则要计算不选num和选num的方案数之和
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}

// @lc code=end

