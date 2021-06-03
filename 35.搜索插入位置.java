/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int sp = -1;
        int ep = -1;
        if (target > nums[n - 1]) {
            return n;
        }
        if (target <= nums[0]) {
            return 0;
        }
        n = n / 2;
        if (nums[n] >= target) {
            sp = 0;
            ep = n;
        } else {
            sp = n;
            ep = nums.length - 1;
        }
        while (ep > sp + 1) {
            n = (sp + ep) / 2;
            if (nums[n] >= target) {
                ep = n;
            } else {
                sp = n;
            }
        }
        return ep;
    }
}
// @lc code=end

