/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        // 整体的思路为，分组异或
        // 将所有的数字分为两组
        // 两个只出现一次的数字在不同的组中；相同的数字会被分到相同的组中。
        // 首先获取两个不同数字的异或结果
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        // 分组，a,b两组
        // 相同的数字与div异或的结果是一样的，所以会被分到相同的组
        // div寻找的是非0的最低位，所以div异或a和b的结果是不一样的，只要将其分开即可
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}

// @lc code=end

