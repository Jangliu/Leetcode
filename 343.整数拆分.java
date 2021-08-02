/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        // 写出几个例子来找规律
        // 发现拆分出的3最多的时候最优
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        // 恰好完全整除的时候
        if(b == 0) {
            return (int) Math.pow(3, a);
        }
        // 余1的时候最后一个3加上1变成1
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        // 余2的时候最后一个2就不拆开了，因为4*4<3*3*2
        return (int)Math.pow(3, a) * 2;
    }
}
// @lc code=end

