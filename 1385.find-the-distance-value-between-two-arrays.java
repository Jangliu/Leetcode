/*
 * @lc app=leetcode id=1385 lang=java
 *
 * [1385] Find the Distance Value Between Two Arrays
 */

// @lc code=start
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int result =0;
        for(int i=0;i<arr1.length;i++){
            int j=0;
            for(;j<arr2.length;j++){
                if(Math.abs(arr1[i]-arr2[j])<=d){
                    break;
                }
            }
            if(j==arr2.length){
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

