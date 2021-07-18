import org.graalvm.compiler.lir.LIRInstruction.Temp;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    // 动态规划法
    public int numSquares(int n) {
        // 设f[i]表示数字i最少需要几个整数的平方相加
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                // 转移方程
                // i=(i-j*j)+j*j,也就是说对于每一个i
                // 只需要找到f[i-j*j]min，再加1就是f[i]
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
}

// @lc code=end

