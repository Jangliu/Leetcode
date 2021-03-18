/*
 * @lc app=leetcode id=326 lang=java
 *
 * [326] Power of Three
 */

// @lc code=start
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0){
            return false;
        }
        int rest = n%3;
        while(rest==0){
            n=n/3;
            rest=n%3;
        }
        return(n==1&&rest==1);
    }
}
// @lc code=end

