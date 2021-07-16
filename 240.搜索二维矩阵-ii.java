/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    // 如果当前指向的值大于目标值，则可以 “向上” 移动一行.
    // 否则，如果当前指向的值小于目标值，则可以移动一列.
    // 因为行是从左到右排序的，当前值右侧的每个值都较大。 
    // 因此，如果当前值已经大于目标值，我们知道它右边的每个值会比较大。
    public boolean searchMatrix(int[][] matrix, int target) {
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}

// @lc code=end

