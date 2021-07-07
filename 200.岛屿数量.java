/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    boolean[][] isVisisted;

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        isVisisted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisisted[i][j] && grid[i][j] == '1') {
                    res++;
                    numIslandsHelper(grid, i, j);
                }
            }
        }
        return res;
    }

    public void numIslandsHelper(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return;
        }
        isVisisted[x][y] = true;
        if (x - 1 >= 0) {
            if (!isVisisted[x - 1][y]) {
                numIslandsHelper(grid, x - 1, y);
            }
        }
        if (x + 1 < grid.length) {
            if (!isVisisted[x + 1][y]) {
                numIslandsHelper(grid, x + 1, y);
            }
        }
        if (y - 1 >= 0) {
            if (!isVisisted[x][y - 1]) {
                numIslandsHelper(grid, x, y - 1);
            }
        }
        if (y + 1 < grid[0].length) {
            if (!isVisisted[x][y + 1]) {
                numIslandsHelper(grid, x, y + 1);
            }
        }
    }
}
// @lc code=end

