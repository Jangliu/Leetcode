/*
 * @lc app=leetcode.cn id=526 lang=java
 *
 * [526] 优美的排列
 */

// @lc code=start
class Solution {
    public int countArrangement(int n) {
        // dp+状态压缩
        // 最多十五个数，用一个十五位的二进制数就可以表示状态，
        int mask = 1 << n;
        int[] dp = new int[mask];
        dp[0] = 1;

        for (int visited = 0; visited < mask; visited++) {
            // 通过visited计算出 i
            int i = Integer.bitCount(visited);
            for (int num = 1; num <= n; num++) {
                if (((1 << (num - 1)) & visited) != 0 && (num % i == 0 || i % num == 0)) {
                    // i - 1 位置没有放入num
                    dp[visited] += dp[visited & (~(1 << (num - 1)))];
                }
            }
        }

        return dp[mask - 1];
    }
}
// @lc code=end

