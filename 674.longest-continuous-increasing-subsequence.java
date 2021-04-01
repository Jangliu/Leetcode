/*
 * @lc app=leetcode id=674 lang=java
 *
 * [674] Longest Continuous Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int result=1;
        int i=0;
        int count=1;
        while(i<nums.length)
        {
            int j=i+1;
            for(;j<nums.length;j++){
                if(nums[j]>nums[j-1]){
                    count++;
                }
                else{
                    result=Math.max(result, count);
                    count=1;
                    break;
                }
            }
            result = Math.max(result, count);
            i=j;
        }
        return result;
    }
}
// @lc code=end

