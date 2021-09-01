/*
 * @lc app=leetcode.cn id=377 lang=java
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 用dp[i]来表示和为i的组合的个数
        // dp[0]=1，即所有元素都不选
        // 对于dp[i]，对于nums中任意一个num，num≤i，那么dp[i]+=dp[i-num]
        // 这样做也可以保证顺序
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int n:nums){
                if(n<=i){
                    dp[i]+=dp[i-n];
                }
            }
        }
        return dp[target];
    }
}
// @lc code=end

