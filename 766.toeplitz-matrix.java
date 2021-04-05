/*
 * @lc app=leetcode id=766 lang=java
 *
 * [766] Toeplitz Matrix
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < n; i++) {
            int check = matrix[0][i];
            int j = 1;
            int k = i + 1;
            while (j < m && k < n) {
                if (matrix[j][k] != check) {
                    return false;
                }
                j++;
                k++;
            }
        }
        for (int i = 1; i < m; i++) {
            int check = matrix[i][0];
            int j = i + 1;
            int k = 1;
            while (j < m && k < n) {
                if (matrix[j][k] != check) {
                    return false;
                }
                j++;
                k++;
            }
        }
        return true;
    }
}
// @lc code=end

