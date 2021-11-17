/*
 * @lc app=leetcode.cn id=486 lang=java
 *
 * [486] 预测赢家
 */

// @lc code=start
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        // 使用动态规划
        // dp[i][j]表示当数组剩下部分的下标是i到j时，当前玩家与另一个玩家的分数之差的最大值
        // 注意此时当前玩家并不一定是先手玩家
        // i<=j才有意义，其余时候dp[i][j]=0；
        // i=j时只剩一个数字，当前玩家只能拿到这个数字，dp[i][j]=nums[i];
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            // 当i<j时，当前玩家选择最优方法
            for (int j = i + 1; j < length; j++) {
                // 状态转移方程
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}

// @lc code=end

