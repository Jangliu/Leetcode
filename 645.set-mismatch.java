/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] val = new int[nums.length];
        int[] result = new int[2]; 
        for(int i=0;i<nums.length;i++){
            val[nums[i]-1]++;
        }
        for(int i=0;i<val.length;i++){
            if(val[i]==0){
                result[1]=i+1;
            }
            if(val[i]==2){
                result[0]=i+1;
            }
        }
        return result;
    }
}
// @lc code=end

