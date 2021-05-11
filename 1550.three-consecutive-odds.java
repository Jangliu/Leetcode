/*
 * @lc app=leetcode id=1550 lang=java
 *
 * [1550] Three Consecutive Odds
 */

// @lc code=start
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length-2;i++){
            if(arr[i]%2!=0){
                if(arr[i+1]%2!=0&&arr[i+2]%2!=0){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

