/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32) {
                return makeGood(s.substring(0, i) + s.substring(i + 2, s.length()));
            }
        }
        return s;
    }
}
// @lc code=end

