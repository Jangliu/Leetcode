/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=-1000001;
        int cur = 0;
        for(int n:nums){
            cur = Math.max(n,cur+n);
            maxSum = Math.max(maxSum, cur);
        }
        return maxSum;
    }
}
// @lc code=end

