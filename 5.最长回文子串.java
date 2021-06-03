/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
public class Solution {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            // 以下标i处的字符作为回文串的中心点
            extendPalindrome(s, i, i);
            // 以i和i+1这两个字符为回文串的中心点
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
            // j为左端点，k为右端点，以一个或者两个字符为中心，往左右拓展，找到最长的回文字符串
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
// @lc code=end

