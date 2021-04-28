import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=1380 lang=java
 *
 * [1380] Lucky Numbers in a Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] rowMins = new int[matrix.length];
        int[] colMaxs = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int rowMin = Integer.MAX_VALUE;
            for(int j=0;j<matrix[0].length;j++){
                rowMin=Math.min(matrix[i][j], rowMin);
            }
            rowMins[i]=rowMin;
        }
        for(int i=0;i<matrix[0].length;i++){
            int colMax = Integer.MIN_VALUE;
            for(int j=0;j<matrix.length;j++){
                colMax=Math.max(colMax, matrix[j][i]);
            }
            colMaxs[i]=colMax;
        }
        for(int i=0;i<rowMins.length;i++){
            for(int j=0;j<colMaxs.length;j++){
                if(colMaxs[j]==rowMins[i]){
                    result.add(colMaxs[j]);
                }
            }
        }
        return result;
    }
}
// @lc code=end

