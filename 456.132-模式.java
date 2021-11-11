/*
 * @lc app=leetcode.cn id=456 lang=java
 *
 * [456] 132 模式
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int top = -1;
        int[] stack = new int[nums.length];
        int minValue = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < minValue) {
                return true;
            }
            while (top > -1 && stack[top] < nums[i]) {
                minValue = Math.max(minValue, stack[top]);
                top--;
            }
            stack[++top] = nums[i];
        }
        return false;
    }
}
// @lc code=end

