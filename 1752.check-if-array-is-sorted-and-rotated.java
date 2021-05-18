/*
 * @lc app=leetcode id=1752 lang=java
 *
 * [1752] Check if Array Is Sorted and Rotated
 */

// @lc code=start
class Solution {
    public boolean check(int[] nums) {
        int count = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]){
                continue;
            }
            if(count>0){
                count--;
            }
            else{
                return false;
            }
        }
        if(count==0){
            return nums[0]>=nums[nums.length-1];
        }
        return true;
    }
}
// @lc code=end

