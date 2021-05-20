/*
 * @lc app=leetcode id=1800 lang=java
 *
 * [1800] Maximum Ascending Subarray Sum
 */

// @lc code=start
class Solution {
    public int maxAscendingSum(int[] nums) {
        int i=0;
        int res=0;
        int last=0;
        while(i<nums.length){
            int j=i;
            int temp=0;
            while(i < nums.length&&last<nums[i]){
                temp+=nums[i];
                last=nums[i];
                i++;
            }
            if(i==j){
                last=nums[i];
                i++;
            }
            else{
                last=0;
            }
            res=Math.max(res, temp);
        }
        return res;
    }
}
// @lc code=end

