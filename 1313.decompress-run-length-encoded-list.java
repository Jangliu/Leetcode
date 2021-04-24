/*
 * @lc app=leetcode id=1313 lang=java
 *
 * [1313] Decompress Run-Length Encoded List
 */

// @lc code=start
class Solution {
    public int[] decompressRLElist(int[] nums) {
        int sum = 0;
        int index=0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        int[] result=new int[sum];
        for(int i=0;i<nums.length;i+=2){
            for(int j=0;j<nums[i];j++){
                result[index]=nums[i+1];
                index++;
            }
        }
        return result;
    }
}
// @lc code=end

