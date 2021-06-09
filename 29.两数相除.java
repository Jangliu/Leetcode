/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        int pdefault = Integer.MAX_VALUE;
        int ndefault = Integer.MIN_VALUE;
        long dd=dividend;
        long dr=divisor;
        long res = dd/dr;
        if(res>pdefault||res<ndefault){
            return pdefault;
        }
        else{
            return (int)res;
        }
    }
}
// @lc code=end

