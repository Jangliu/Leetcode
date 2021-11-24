import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        // 动态规划
        // dp[i]凑成i金额的组合数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 外层循环遍历数组coins的值，内层循环遍历不同金额的和
        // 可以确保金额之和等于i的硬币面额的顺序。
        // 顺序确定那么组合就不会重复了
        // 比如conis=[1,2]
        // 对于dp[3]的计算一定是先遍历硬币面额1后再遍历硬币面额2
        // 所以只会出现：3=1+1+1，3=1+2
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

