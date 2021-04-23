/*
 * @lc app=leetcode id=1252 lang=java
 *
 * [1252] Cells with Odd Values in a Matrix
 */

// @lc code=start
class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        int result = 0;
        for(int i=0;i<indices.length;i++){
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        for(int i=0;i<rows.length;i++){
            for(int j=0;j<cols.length;j++){
                if((rows[i]+cols[j])%2!=0){
                    result++;
                }
            }
        }
        return result;
    }
}
// @lc code=end

