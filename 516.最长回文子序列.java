import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=516 lang=java
 *
 * [516] 最长回文子序列
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        // 动态规划法
        int n = s.length();
        // dp[i][j]表示下标[i,j]这一段中最长的回文子序列的长度
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 最短为1
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < n; j++) {
                char c2 = s.charAt(j);
                // 如果首尾相等，那么就是中间的最长的回文子序列长度+2
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 否则就是中间的最长的回文子序列的长度
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}

// @lc code=end

