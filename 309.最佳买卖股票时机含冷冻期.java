import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=309 lang=java
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 动态规划法
        if (prices.length == 0) {
            return 0;
        }
        // 设f[i]表示第i天结束之后的累积最大收益
        // 根据条件此时会有三种不同的状态
        // 当前持有一只股票，对应的累积最大收益为f[i][0]
        // 当前不持有股票，且处于冷冻期内，对应的累计最大收益为f[i][1]
        // 当前不持有股票，并且不处于冷冻期内，对应的累积最大收益为f[i][2]
        // 这里的「处于冷冻期」指的是在第 i天结束之后的状态。
        // 也就是说：如果第 i天结束之后处于冷冻期，那么第 i+1天无法买入股票。
        // 状态转移方程如下：
        // 对于f[i][0]，当前持有的股票可以是前一天持有的，也可以是第i天买入的
        // f[i][0]=Max(f[i-1][0],f[i-1][2]-price[i])
        // 对于f[i][1]
        // f[i][1]=f[i-1][0]+price[i-1]
        // 对于f[i][2]
        // f[i][2]=Max(f[i-1][1],f[i-1][2])
        // 对于第0天的边界条件如下
        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        // 由于每一个状态只与前一天的状态有关，所以只需要使用常量的空间
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }
}

// @lc code=end

