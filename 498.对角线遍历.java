/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) {
            return new int[0];
        }
        int rowLength = mat.length;
        int columLength = mat[0].length;
        int count = rowLength + columLength - 1;
        int[] res = new int[rowLength * columLength];
        int index = 0;
        int m = 0, n = 0;
        for (int i = 0; i < count; ++i) {
            if (i % 2 == 0) {
                while (m >= 0 && n < columLength) {
                    res[index++] = mat[m][n];
                    m--;
                    n++;
                }
                if (n < columLength) {
                    m++;

                } else {
                    m = m + 2;
                    n--;
                }
            } else {
                while (m < rowLength && n >= 0) {
                    res[index++] = mat[m][n];
                    m++;
                    n--;
                }
                if (m < rowLength) {
                    n++;
                } else {
                    m--;
                    n = n + 2;
                }
            }

        }
        return res;
    }
}

// @lc code=end

