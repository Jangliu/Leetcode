/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        long sp = 1;
        long ep = num;
        long mid = (sp + ep) / 2;
        while (ep - sp > 1) {
            if (mid * mid >= num) {
                ep = mid;
                mid = (sp + ep) / 2;
                continue;
            }
            sp = mid;
            mid = (sp + ep) / 2;
        }
        return sp * sp == num || ep * ep == num;
    }
}
// @lc code=end

