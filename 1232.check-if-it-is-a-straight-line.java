/*
 * @lc app=leetcode id=1232 lang=java
 *
 * [1232] Check If It Is a Straight Line
 */

// @lc code=start
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] vector = new int[2];
        vector[0]=coordinates[1][0]-coordinates[0][0];
        vector[1]=coordinates[1][1]-coordinates[0][1];
        if(vector[0]==0){
            int i=0;
            for(;i<coordinates.length;i++){
                if(coordinates[i][0]!=coordinates[0][0]){
                    break;
                }
            }
            if(i!=coordinates.length){
                return false;
            }
        }
        if(vector[1]==0){
            int i=0;
            for(;i<coordinates.length;i++){
                if(coordinates[i][1]!=coordinates[0][1]){
                    break;
                }
            }
            if(i!=coordinates.length){
                return false;
            }
        }
        for(int i=2;i<coordinates.length;i++){
            int[] temp = new int[2];
            temp[0]=coordinates[i][0]-coordinates[i-1][0];
            temp[1]=coordinates[i][1]-coordinates[i-1][1];
            if(vector[1]*temp[0]!=vector[0]*temp[1]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

