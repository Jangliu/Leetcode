/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        char[] c = new char[52];
        int maxOdd = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 90) {
                c[s.charAt(i) - 65]++;
                continue;
            }
            c[s.charAt(i) - 71]++;
        }
        for (int i = 0; i < 52; i++) {
            if (c[i] % 2 == 0) {
                count += c[i];
                continue;
            }
            count += c[i] - 1;
            maxOdd = 1;

        }
        return count + maxOdd;
    }
}
// @lc code=end

