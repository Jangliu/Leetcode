/*
 * @lc app=leetcode id=453 lang=java
 *
 * [453] Minimum Moves to Equal Array Elements
 */

// @lc code=start
class Solution {
    public int minMoves(int[] nums) {
        if (nums.length <= 1)
            return 0;
        long min = (long) nums[0];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            min = Math.min(min, nums[i]);
        }
        return (int) (sum - min * nums.length);
    }
}
// @lc code=end

