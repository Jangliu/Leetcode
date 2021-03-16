/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        while(n>=2){
            if(n%2!=0&&n%3!=0&&n%5!=0){
                return false;
            }
            else{
                if(n%2==0){
                    n=n/2;
                    continue;
                }
                if(n%3==0){
                    n=n/3;
                    continue;
                }
                n=n/5;
            }
        }
        return true;
    }
}
// @lc code=end

