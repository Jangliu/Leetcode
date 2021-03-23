/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        for (int i = 1; i < s.length() / 2 + 1; i++) {
            if (s.length() % i == 0) {
                String check = s.substring(0, i);
                for (int j = i; j <= s.length() - i; j += i) {
                    String temp = s.substring(j, j + i);
                    if (check.equals(temp)) {
                        if (j == s.length() - i) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
}
// @lc code=end

