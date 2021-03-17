/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int sum = (nums.length+1)*nums.length/2;
        for(int i=0;i<nums.length;i++){
            sum-=nums[i];
        }
        return sum;
    }
}
// @lc code=end

