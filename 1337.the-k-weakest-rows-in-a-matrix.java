/*
 * @lc app=leetcode id=1337 lang=java
 *
 * [1337] The K Weakest Rows in a Matrix
 */

// @lc code=start
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] rank = new int[mat.length][2];
        // rank[0]=士兵数量
        // rank[1]=行的下标
        for (int i = 0; i < mat.length; i++) {
            rank[i][1] = i;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    rank[i][0] += mat[i][j];
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat.length - i; j++) {
                if (rank[j][0] < rank[j + 1][0] || (rank[j][0] == rank[j + 1][0] && rank[j][1] < rank[j + 1][1])) {
                    int[] temp = rank[j + 1];
                    rank[j + 1] = rank[j];
                    rank[j] = temp;
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rank[rank.length - i - 1][1];
        }
        return result;
    }
}
// @lc code=end

