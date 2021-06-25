/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        // 设f[i]为字符串s前i个字符的解码方法数
        // 那么每次往后走就有两种情况：1.只用一个字符解码 2.用两个字符解码

        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                // 只用一个字符解码
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                // 用两个字符解码
                c += a;
            }
            // 更新a,b,c的值
            a = b;
            b = c;
        }
        return c;
    }
}
// @lc code=end

