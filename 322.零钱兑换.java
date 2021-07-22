import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // 采用动态规划法
        // 设dp[i]表示组成金额i所需的最小硬币数量
        // dp[i]=min(dp[i-cj])+1，其中cj代表第j枚硬币的面额
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        // 将dp的每一个值都设置为最大值
        // 将dp的每一个值都设置为最大值,这是为了保证如果找不到答案方便返回-1。
        Arrays.fill(dp, max);
        // 金额0不需要硬币，所以为0
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 这个判断条件是为了让i-coins[j]>=0,确保其有意义
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

