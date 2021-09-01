/*
 * @lc app=leetcode.cn id=375 lang=java
 *
 * [375] 猜数字大小 II
 */

// @lc code=start
class Solution {
    public int getMoneyAmount(int n) {
        // 使用dp[i][j]来表示从数字i到数字j之间选择一个数字至少需要多少钱
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return getMoneyAmountDfs(dp, 1, n);
    }

    private int getMoneyAmountDfs(int[][] dp, int l, int r) {
        if (l >= r) {
            return 0;
        }
        // 如果已经被更新过即可跳过
        if (dp[l][r] != Integer.MAX_VALUE) {
            return dp[l][r];
        }
        // 从l...r这个范围内选择起点的话前半段的可以放弃，因为必然金额是远远大于最少现金值
        for (int i = (r + l) / 2; i <= r; i++) {
            // 更新规则：左边范围的最少现金+i+右边范围的最少现金
            dp[l][r] = Math.min(dp[l][r],
                    i + Math.max(getMoneyAmountDfs(dp, l, i - 1), getMoneyAmountDfs(dp, i + 1, r)));
        }
        return dp[l][r];
    }
}

// @lc code=end

