/*
 * @lc app=leetcode id=832 lang=java
 *
 * [832] Flipping an Image
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n=image.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = image[i][j];
                image[i][j]=image[i][n-1-j];
                image[i][n-1-j]=temp;
            }
            for(int j=0;j<n;j++){
                image[i][j]=image[i][j]==1?0:1;
            }
        }
        return image;
    }
}
// @lc code=end

