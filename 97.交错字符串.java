/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        if (n + m != t) {
            return false;
        }
        // 用数组f[i][j]表示s1的前i个元素和s2的前j个元素是否能组成s3的前i+j个元素
        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    // 如果s1的第i个元素和s3的第i+j个元素相等
                    // s1的前i个元素和s2的前j个元素是否能交错组成s3的前i+j个元素
                    // 取决于s1的前i-1个元素和s2的前j个元素是否能交错组成s3的前i+j-1个元素
                    // 即f[i][j]取决于f[i-1][j]
                    f[i][j] = f[i][j] || (f[i - 1][j] && c1[i - 1] == c3[p]);
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && c2[j - 1] == c3[p]);
                }
            }
        }

        return f[n][m];
    }

}

// @lc code=end

