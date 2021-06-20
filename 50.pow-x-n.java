/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        //N大于0就是正常的计算
        //N小于0就是原来结果的倒数
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        //递归计算
        //要计算x的n次方时，我们可以先计算x的[n/2]次方，[]表示向下取整
        //这样递归以后，最后一次的n要么是2要么是3
        //那么最后一轮就直接计算即可
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}
// @lc code=end

