/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
            //result = result ^i;按位异或的意思。
            //因为只有一个元素只出现一次，别的元素都会出现两次，相同元素异或得0，0异或任何数等于任何数
        }
        return result;
    }
}
// @lc code=end

