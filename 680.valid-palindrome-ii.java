/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public static boolean validPalindrome(String s) {
        int sp = 0;
        int ep = s.length() - 1;
        while (sp <= s.length() / 2 && ep >= s.length() / 2) {
            if (s.charAt(sp) != s.charAt(ep)) {
                if (s.charAt(sp) == s.charAt(ep - 1) || s.charAt(sp + 1) == s.charAt(ep)) {
                    String s1 = s.substring(0, sp) + s.substring(sp + 1, s.length());
                    String s2 = s.substring(0, ep) + s.substring(ep + 1, s.length());
                    return checkPalindrome(s1) || checkPalindrome(s2);
                } else {
                    return false;
                }
            }
            sp = sp + 1;
            ep = ep - 1;
        }
        return true;
    }

    public static boolean checkPalindrome(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

