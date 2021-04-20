/*
 * @lc app=leetcode id=1037 lang=java
 *
 * [1037] Valid Boomerang
 */

// @lc code=start
class Solution {
    public boolean isBoomerang(int[][] points) {
        int r1 = (points[1][1] - points[0][1]);
        int r2 = (points[1][0] - points[0][0]);
        int r3 = (points[2][1] - points[0][1]);
        int r4 = (points[2][0] - points[0][0]);
        return r2 * r3 != r1 * r4;
    }
}
// @lc code=end

