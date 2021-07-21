/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] 超级丑数
 */

// @lc code=start
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp=new int[n];
        dp[0]=1;
        int[] p= new int[primes.length];
        for(int i=1;i<n;i++){
            int min = dp[p[0]]*primes[0];
            for(int j=0;j<p.length;j++){
                if(dp[p[j]]*primes[j]<min){
                    min=dp[p[j]]*primes[j];
                }
            }
            // 与丑数问题不同的是
            // 由于这里primes的长度不定，所以对于primes中所有乘积满足条件的，都要调位置
            for(int j=0;j<p.length;j++){
                if(dp[p[j]]*primes[j]==min){
                    p[j]++;
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }
}
// @lc code=end

