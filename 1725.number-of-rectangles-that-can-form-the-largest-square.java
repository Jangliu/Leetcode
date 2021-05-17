/*
 * @lc app=leetcode id=1725 lang=java
 *
 * [1725] Number Of Rectangles That Can Form The Largest Square
 */

// @lc code=start
class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int res=0;
        int maxLen=0;
        for(int i=0;i<rectangles.length;i++){
            int temp = Math.min(rectangles[i][0], rectangles[i][1]);
            if(temp>maxLen){
                res=1;
                maxLen=temp;
                continue;
            }
            if(temp==maxLen){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

