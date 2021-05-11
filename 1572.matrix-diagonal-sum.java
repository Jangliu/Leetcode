/*
 * @lc app=leetcode id=1572 lang=java
 *
 * [1572] Matrix Diagonal Sum
 */

// @lc code=start
class Solution {
    public int diagonalSum(int[][] mat) {
        int result=0;
        boolean[][] mark = new boolean[mat.length][mat.length];
        for(int i=0;i<mat.length;i++){
            mark[i][i]=true;
            result+=mat[i][i];
        }
        for(int j=mat.length-1,i=0;j>=0&&i<mat.length;j--,i++){
            if(!mark[i][j]){
                result+=mat[i][j];
            }
        }
        return result;
    }
}
// @lc code=end

