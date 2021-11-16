import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=477 lang=java
 *
 * [477] 汉明距离总和
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        // 把每个数字都看成是一个由30个bit构建的整数
        // 那么只需要统计nums数组中的每一个num在第i个比特上的情况
        // 比如整个数组在第i位上有c个1，那么这一位能提供的汉明码距离就是c*(n-c)，n为数组长度
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
// @lc code=end

