/*
 * @lc app=leetcode id=1827 lang=java
 *
 * [1827] Minimum Operations to Make the Array Increasing
 */

// @lc code=start
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i - 1] - nums[i] + 1;
                count += diff;
                nums[i] += diff;
            }
        }
        return count;
    }
}
// @lc code=end

