/*
 * @lc app=leetcode id=883 lang=java
 *
 * [883] Projection Area of 3D Shapes
 */

// @lc code=start
class Solution {
    public int projectionArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {

            int max1 = -1, max2 = -1;

            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 0)
                    sum++; // xy axis - if value is greater than zero, means cube is there
                if (grid[i][j] > max1)
                    max1 = grid[i][j]; // xz axis - max element in row
                if (grid[j][i] > max2)
                    max2 = grid[j][i]; // yz axiz - max element in column
                //因为限制了gird是一个方阵，所以可以这么做
            }
            sum = sum + max1 + max2;
        }
        return sum;
    }
}
// @lc code=end

