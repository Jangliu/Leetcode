/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 */

// @lc code=start
class Solution {
    public boolean canWinNim(int n) {
        if(n<=3){
            return true;
        }
        if(n%4==0){
            return false;
        }
        return true;
    }
}
// @lc code=end

