/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int rest = n % 2;
        int number = n / 2;
        while (number >=1) {
            if (rest != 0) {
                return false;
            }
            rest = number % 2;
            number = number / 2;
        }
        return true;
    }
}
// @lc code=end

