/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int res = 0;
        int i = 0;
        while (i < nums.length) {
            int index = i;
            int farest = i + nums[i];
            if (farest >= nums.length - 1) {
                res++;
                break;
            }
            for (int j = 1; j <= nums[i]; j++) {
                if (farest <= nums[i + j] + i + j) {
                    index = i + j;
                    farest = nums[i + j] + i + j;
                }
            }
            res++;
            i = index;
        }
        return res;
    }
}
// @lc code=end

