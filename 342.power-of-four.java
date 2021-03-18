/*
 * @lc app=leetcode id=342 lang=java
 *
 * [342] Power of Four
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        int rest = n % 4;
        while (rest == 0) {
            n = n / 4;
            rest = n % 4;
        }
        return (n == 1 && rest == 1);   
    }
}
// @lc code=end

