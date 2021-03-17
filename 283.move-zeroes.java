/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroIndex=i;
                break;
            }
        }
        if(zeroIndex==-1){
            return;
        }
        for(int i=zeroIndex+1;i<nums.length;i++){
            if(nums[i]!=0){
                nums[zeroIndex]=nums[i];
                nums[i]=0;
                zeroIndex++;
            }
        }
    }
}
// @lc code=end

