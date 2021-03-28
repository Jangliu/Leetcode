/*
 * @lc app=leetcode id=566 lang=java
 *
 * [566] Reshape the Matrix
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c>nums.length*nums[0].length){
            return nums;
        }
        int[] sum = new int[r*c];
        int sIndex=0;
        int[][] result = new int[r][c];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                sum[sIndex]=nums[i][j];
                sIndex++;
            }
        }
        int k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                result[i][j]=sum[k];
                k++;
            }
        }
        return result;
    }
}
// @lc code=end

