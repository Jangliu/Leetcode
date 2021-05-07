/*
 * @lc app=leetcode id=1450 lang=java
 *
 * [1450] Number of Students Doing Homework at a Given Time
 */

// @lc code=start
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for(int i=0;i<startTime.length;i++){
            if(startTime[i]<=queryTime&&endTime[i]>=queryTime){
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

