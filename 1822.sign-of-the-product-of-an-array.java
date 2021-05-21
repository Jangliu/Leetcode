/*
 * @lc app=leetcode id=1822 lang=java
 *
 * [1822] Sign of the Product of an Array
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        int positive=0;
        int negative=0;
        for(int n:nums){
            if(n==0){
                return 0;
            }
            if(n>0){
                positive++;
            }
            if(n<0){
                negative++;
            }
        }
        return negative%2==0?1:-1;
    }
}
// @lc code=end

