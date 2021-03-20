/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() <= s.length()) {
            return t.equals(s);
        }
        int i = 0;
        int j = 0;
        for (; i < s.length(); i++) {
            for (; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                    break;
                }
            }
            if (j == t.length() && s.charAt(i) != t.charAt(j - 1)) {
                return false;
            }
        }
        return s.charAt(i - 1) == t.charAt(j - 1);
    }
}
// @lc code=end

