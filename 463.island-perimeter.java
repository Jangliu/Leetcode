/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]!=0){
                    int perimeter = 4;
                    if(j-1>=0){
                        if(grid[i][j-1]==1){
                            perimeter-=1;
                        }
                    }
                    if(j+1<grid[i].length){
                        if(grid[i][j+1]==1){
                            perimeter-=1;
                        }
                    }
                    if(i-1>=0&&grid[i-1][j]==1){
                        if(grid[i-1][j]==1){
                            perimeter-=1;
                        }
                    }
                    if(i+1<grid.length){
                        if(grid[i+1][j]==1){
                            perimeter-=1;
                        }
                    }
                    count+=perimeter;
                }
            }
        }
        return count;
    }
}
// @lc code=end

