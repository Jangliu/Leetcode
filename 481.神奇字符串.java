/*
 * @lc app=leetcode.cn id=481 lang=java
 *
 * [481] 神奇字符串
 */

// @lc code=start
class Solution {
    public int magicalString(int n) {
        if (n <= 1) {
            return n;
        }
        int res = 1;
        // magic记录magic序列
        // count记录出现的次数序列
        int[] magic = new int[n + 2];
        int[] count = new int[n + 2];
        magic[0] = 1;
        count[0] = 1;
        count[1] = 2;
        // 用count序列去构建magic序列
        int i = 1, j = 1;
        while (i < n) {
            // 根据count去构建下一组magic序列
            if (count[j] == 1) {
                if (magic[i - 1] == 1) {
                    magic[i] = 2;
                } else {
                    magic[i] = 1;
                    res++;
                }
                i++;
            } else {
                if (magic[i - 1] == 1) {
                    magic[i] = 2;
                    magic[i + 1] = 2;
                } else {
                    magic[i] = 1;
                    magic[i + 1] = 1;
                    res += 2;
                }
                i += 2;
            }
            j++;
            count[j] = magic[j];
        }
        for (int k = n; k < n + 2; k++) {
            if (magic[k] == 1) {
                res--;
            }
        }
        return res;
    }
}
// @lc code=end

