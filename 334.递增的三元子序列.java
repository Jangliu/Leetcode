/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // dp1为目前遍历到的最小值
        // dp2为目标遍历到的次小值
        // 从前往后遍历这样就能保证顺序即下标要求
        int dp1 = Integer.MAX_VALUE;
        int dp2 = Integer.MAX_VALUE;
        for(int num : nums) {
            // 这个遍历方法保证的是dp2的前面一定有一个数比dp2还要小
            // 那么此时只需要遍历到一个数比dp2大，即符合题意
            if(num < dp1) {
                dp1 = num;
            } else if (num > dp1 && num < dp2) {
                dp2 = num;
            } else if (num > dp2) {
                return true;
            }
        }
        return false;
    }
}

// @lc code=end

