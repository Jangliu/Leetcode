/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 使用动态规划，设f[i][j]表示从左上角走到[i][j]的路径数量
        // 那么f[i][j]=f[i-1][j]+f[i][j-1];
        // 最终答案就是f[m-1][n-1]
        // 但是如果[i][j]处有障碍，那么就为0
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        // 两个边界上点都为1，因为只有一种路径
        // 如果边界上某一个点是障碍，那么这个点后面的边界都无法到达
        // 即路径都为0
        for (int i = 0; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                f[i][0] = 0;
                break;
            } else {
                f[i][0] = 1;
            }
        }
        for (int j = 0; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                f[0][j] = 0;
                break;
            } else {
                f[0][j] = 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        return f[m - 1][n - 1];
    }
}

// @lc code=end

