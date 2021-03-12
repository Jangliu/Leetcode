/*
 * @lc app=leetcode id=175 lang=java
 *
 * [175] Combine Two Tables
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int number = n/5;
        int count=0;
        while(number>0){
            count+=number;
            number=number/5;
        }
        return count;
    }
}
// @lc code=end

