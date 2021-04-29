/*
 * @lc app=leetcode id=1413 lang=java
 *
 * [1413] Minimum Value to Get Positive Step by Step Sum
 */

// @lc code=start
class Solution {
    public int minStartValue(int[] nums) {
        int result = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
            result=Math.min(result, nums[i]);
        }
        return result>=0?1:1-result;
    }
}
// @lc code=end

