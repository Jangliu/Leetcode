import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 使用状态转移法
        // 首先进行前置判断
        int n = nums.length;
        // 如果数组长度为1，则不符合题意
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // 如果数组总和为奇数，则不符合题意
        if (sum % 2 != 0) {
            return false;
        }
        // 如果数组最大元素大于总和的一半，那说明其余所有元素之和小于总和的一半
        // 不符合题意
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // 使用dp[][],包含n行target+1列
        // 其中dp[i][j]表示从数组的[0,i]下标范围内选取若干个正整数（可以是0个），是否存在一种选取方案使得被选取正整数的和等于j
        // 初始时dp中元素都为false
        boolean[][] dp = new boolean[n][target + 1];
        // dp[i][0]表示不选任何数，则为true
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // i=0时只有一个正整数nums[0]可以被选取，所以为true
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            // j>=nums[i]时
            // dp[i][j]=dp[i-1][j](不选取nums[i])|dp[i-1][j-nums[i]](选取nums[i])
            // j<nums[i]时 当前数字nums[i]肯定不能选取，所以dp[i][j]=dp[i-1][j]
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}

// @lc code=end

