/*
 * @lc app=leetcode id=1266 lang=java
 *
 * [1266] Minimum Time Visiting All Points
 */

// @lc code=start
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for(int i=0;i<points.length-1;i++){
            int x= Math.abs(points[i][0]-points[i+1][0]);
            int y= Math.abs(points[i][1]-points[i+1][1]);
            result+=Math.min(x, y)+Math.abs(x-y);
        }
        return result;
    }
}
// @lc code=end

