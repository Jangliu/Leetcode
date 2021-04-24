/*
 * @lc app=leetcode id=1295 lang=java
 *
 * [1295] Find Numbers with Even Number of Digits
 */

// @lc code=start
class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int temp = nums[i];
            int digits = 0;
            while(temp>=10){
                digits++;
                temp=temp/10;
            }
            digits++;
            if(digits%2==0){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

