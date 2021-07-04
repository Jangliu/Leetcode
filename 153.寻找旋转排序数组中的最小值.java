/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sp=0;
        int ep=nums.length-1;
        if(nums[sp]<nums[ep]){
            return nums[0];
        }
        else{
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]<nums[i]){
                    return nums[i+1];
                }
            }
        }
        return 0;
    }
}
// @lc code=end

