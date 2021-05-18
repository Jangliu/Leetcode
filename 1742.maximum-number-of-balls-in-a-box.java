/*
 * @lc app=leetcode id=1742 lang=java
 *
 * [1742] Maximum Number of Balls in a Box
 */

// @lc code=start
class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] val = new int[46];
        int res=0;
        for(int i=lowLimit;i<=highLimit;i++){
            int index=0;
            int n=i;
            while(n>=10){
                index+=n%10;
                n=n/10;
            }
            index+=n;
            val[index]++;
        }
        for(int i=0;i<val.length;i++){
            res=Math.max(res, val[i]);
        }
        return res;
    }
}
// @lc code=end

