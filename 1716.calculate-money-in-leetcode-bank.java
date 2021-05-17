/*
 * @lc app=leetcode id=1716 lang=java
 *
 * [1716] Calculate Money in Leetcode Bank
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        int num = n/7;
        int rest=n%7;
        int res=0;
        for(int i=0;i<num;i++){
            res+=28+7*i;
        }
        for(int i=0;i<rest;i++){
            res+=num+1+i;
        }
        return res;
    }
}
// @lc code=end

