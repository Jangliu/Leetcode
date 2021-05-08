/*
 * @lc app=leetcode id=1470 lang=java
 *
 * [1470] Shuffle the Array
 */

// @lc code=start
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2*n];
        int index=0;
        for(int i=0;i<n;i++){
            result[index]=nums[i];
            result[index+1]=nums[n+i];
            index+=2;
        }
        return result;
    }
}
// @lc code=end

