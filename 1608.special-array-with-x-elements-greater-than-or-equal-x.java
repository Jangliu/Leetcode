import java.util.Arrays;

/*
 * @lc app=leetcode id=1608 lang=java
 *
 * [1608] Special Array With X Elements Greater Than or Equal X
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length; i >= 1; i--) {
            if (nums[nums.length - i] >= i) {
                if (nums.length - i - 1 >= 0) {
                    if (nums[nums.length - i - 1] < i) {
                        return i;
                    }
                } else {
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

