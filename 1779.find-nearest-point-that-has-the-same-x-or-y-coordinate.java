/*
 * @lc app=leetcode id=1779 lang=java
 *
 * [1779] Find Nearest Point That Has the Same X or Y Coordinate
 */

// @lc code=start
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res=10000;
        int smallDistance=Integer.MAX_VALUE;
        for(int i=0;i<points.length;i++){
            if(points[i][0]==x||points[i][1]==y){
                if(Math.abs(x-points[i][0])+Math.abs(y-points[i][1])<smallDistance){
                    smallDistance=Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                    res=i;
                }
                if(Math.abs(x-points[i][0])+Math.abs(y-points[i][1])==smallDistance){
                    res=Math.min(res, i);
                }
            }
        }
        return res==10000?-1:res;
    }
}
// @lc code=end

