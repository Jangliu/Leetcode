/*
 * @lc app=leetcode id=747 lang=java
 *
 * [747] Largest Number At Least Twice of Others
 */

// @lc code=start
class Solution {
    public int dominantIndex(int[] nums) {
        int fristLargest = -1;
        int secondLargest = -1;
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= fristLargest) {
                secondLargest = fristLargest;
                fristLargest = nums[i];
                if (fristLargest >= 2 * secondLargest) {
                    result = i;
                } else {
                    result = -1;
                }
                continue;
            }
            if (nums[i] >= secondLargest) {
                secondLargest = nums[i];
                if (fristLargest < 2 * secondLargest) {
                    result = -1;
                }
                continue;
            }
        }
        return result;
    }
}
// @lc code=end

