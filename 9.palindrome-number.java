/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        long k = Math.toIntExact((long) x);
        if(x<0){
            return false;
        }
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r==k;
    }
}
// @lc code=end

