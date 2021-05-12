import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode id=1582 lang=java
 *
 * [1582] Special Positions in a Binary Matrix
 */

// @lc code=start
class Solution {
public int numSpecial(int[][] mat) {
        int sum=0;
        int count=0;
        int h=-1;
        for(int i=0;i<mat.length;i++){
            count=0;
            h=-1;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1){
                    count++;
                    h=j;
                }
            }
            if(h!=-1){
            for(int j=0;j<mat.length;j++){
                if(mat[j][h]==1){
                    count++;
                }
            }
            }
            if(count==2){
                sum++;
            }
        }
        return sum;
    }
}

// @lc code=end

