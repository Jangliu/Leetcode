/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }
        int i = 1;
        while (i < nums.length - 1) {
            if (nums[i] - nums[i - 1] == nums[i + 1] - nums[i]) {
                int dx = nums[i] - nums[i - 1];
                int len = 3;
                int j = i + 2;
                for (; j < nums.length; j++) {
                    if (nums[j] - nums[j - 1] == dx) {
                        len++;
                    } else {
                        break;
                    }
                }
                i = j;
                res += (len - 1) * (len - 2) / 2;

            } else {
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

