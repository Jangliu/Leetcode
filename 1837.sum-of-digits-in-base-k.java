/*
 * @lc app=leetcode id=1837 lang=java
 *
 * [1837] Sum of Digits in Base K
 */

// @lc code=start
class Solution {
    public int sumBase(int n, int k) {
        int res=0;
        while(n>=k){
            res+=n%k;
            n=n/k;
        }
        res+=n;
        return res;
    }
}
// @lc code=end

