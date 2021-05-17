/*
 * @lc app=leetcode id=1688 lang=java
 *
 * [1688] Count of Matches in Tournament
 */

// @lc code=start
class Solution {
    public int numberOfMatches(int n) {
        int res=0;
        while(n>1){
            res+=n/2;
            n=n%2==0?n/2:n/2+1;
        }
        return res;
    }
}
// @lc code=end

