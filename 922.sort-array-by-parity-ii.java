/*
 * @lc app=leetcode id=922 lang=java
 *
 * [922] Sort Array By Parity II
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int ep=0;
        int op=1;
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                result[ep]=nums[i];
                ep+=2;
            }
            else{
                result[op]=nums[i];
                op+=2;
            }
        }
        return result;
    }
}
// @lc code=end

