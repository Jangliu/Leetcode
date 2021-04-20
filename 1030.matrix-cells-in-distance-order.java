/*
 * @lc app=leetcode id=1030 lang=java
 *
 * [1030] Matrix Cells in Distance Order
 */

// @lc code=start
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];
        result[0][0] = r0;
        result[0][1] = c0;
        boolean[][] flags = new boolean[R][C];
        int index = 1;
        int maxManhattanDistance = Math.max(R - r0, r0) + Math.max(C - c0, c0);
        for (int i = 1; i <= maxManhattanDistance; i++) {
            for (int j = 1; j <= i; j++) {
                int k = i - j;
                // 右下
                if (r0 + j < R && c0 + k < C) {
                    if (!flags[r0 + j][c0 + k]) {
                        result[index][0] = r0 + j;
                        result[index][1] = c0 + k;
                        flags[r0 + j][c0 + k] = true;
                        index++;
                    }
                }
                if (r0 + k < R && c0 + j < C) {
                    if (!flags[r0 + k][c0 + j]) {
                        result[index][0] = r0 + k;
                        result[index][1] = c0 + j;
                        flags[r0 + k][c0 + j] = true;
                        index++;
                    }
                }
                // 右上
                if (r0 - j >= 0 && c0 + k < C) {
                    if (!flags[r0 - j][c0 + k]) {
                        result[index][0] = r0 - j;
                        result[index][1] = c0 + k;
                        flags[r0 - j][c0 + k] = true;
                        index++;
                    }
                }
                if (r0 - k >= 0 && c0 + j < C) {
                    if (!flags[r0 - k][c0 + j]) {
                        result[index][0] = r0 - k;
                        result[index][1] = c0 + j;
                        flags[r0 - k][c0 + j] = true;
                        index++;
                    }
                }
                // 左上
                if (r0 - j >= 0 && c0 - k >= 0) {
                    if (!flags[r0 - j][c0 - k]) {
                        result[index][0] = r0 - j;
                        result[index][1] = c0 - k;
                        flags[r0 - j][c0 - k] = true;
                        index++;
                    }
                }
                if (r0 - k >= 0 && c0 - j >= 0) {
                    if (!flags[r0 - k][c0 - j]) {
                        result[index][0] = r0 - k;
                        result[index][1] = c0 - j;
                        flags[r0 - k][c0 - j] = true;
                        index++;
                    }
                }
                // 左下
                if (r0 + j < R && c0 - k >= 0) {
                    if (!flags[r0 + j][c0 - k]) {
                        result[index][0] = r0 + j;
                        result[index][1] = c0 - k;
                        flags[r0 + j][c0 - k] = true;
                        index++;
                    }
                }
                if (r0 + k < R && c0 - j >= 0) {
                    if (!flags[r0 + k][c0 - j]) {
                        result[index][0] = r0 + k;
                        result[index][1] = c0 - j;
                        flags[r0 + k][c0 - j] = true;
                        index++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

