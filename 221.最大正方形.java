/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    // 动态规划法
    // 用dp[i][j]来表示以[i][j]为右下角，且只包含1的正方形的变长的最大值
    // 这样最大正方形的面积就是dp[i][j]最大值的平方
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 在边界上就设置为1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 转移方程，dp[i][j]的值由其上方，左上方，左方的三个相邻位置dp的值决定
                        // 因为要包含成正方形，所以要由那三个位置的最小值来决定
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}

// @lc code=end

