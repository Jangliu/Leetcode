/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        // dp[i][j][k]表示前i个字符串中使用j个0和k个1的情况下最多有多个子串
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int zeros = getZeros(strs[i - 1]);
            int ones = strs[i - 1].length() - zeros;
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 前i个字符串中子串的最大数目至少等于前i-1个字符串中子串的最大数目
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    public int getZeros(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

