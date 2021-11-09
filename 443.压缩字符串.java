/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int lastIndex = 0;
        int res = 0;
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            int j = i + 1;
            while (j < chars.length) {
                if (chars[j] != c) {
                    break;
                }
                j++;
            }
            chars[lastIndex] = c;
            lastIndex++;
            res++;
            if (j - i != 1) {
                char[] temp = compressHelper(j - i);
                for (int k = 0; k < temp.length; k++) {
                    chars[lastIndex++] = temp[k];
                    res++;
                }
            }
            i = j;
        }
        return res;
    }

    public char[] compressHelper(int n) {
        int length = (int) Math.log10(n) + 1;
        char[] res = new char[length];
        int index = length - 1;
        while (n >= 10) {
            res[index] = (char) ('0' + n % 10);
            n = n / 10;
            index--;
        }
        res[index] = (char) ('0' + n);
        return res;
    }
}
// @lc code=end

