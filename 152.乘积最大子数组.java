import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        //使用动态规划
        //fmax代表以第i个数字为结尾的子数组的最大乘积
        //fmin代表以第i个数字为结尾的子数组的最小乘积
        int res = nums[0];
        int fmax = nums[0];
        int fmin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                fmax = Math.max(nums[i], fmax * nums[i]);
                fmin = Math.min(nums[i], fmin * nums[i]);
            } else {
                int a = fmax;
                int b = fmin;
                fmax = Math.max(nums[i], b * nums[i]);
                fmin = Math.min(nums[i], a * nums[i]);
            }
            res = Math.max(fmax, res);
        }
        return res;
    }
}
// @lc code=end

