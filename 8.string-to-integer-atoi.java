/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        //stupid problem
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = (str.charAt(0) == '-') ? -1 : 1;
            if (str.length() < 2 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
            i++;
        }
        int n = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int d = str.charAt(i) - '0';
                if (n > (Integer.MAX_VALUE - d) / 10) { // Detect the integer overflow.
                    n = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return n;
                }
                n = n * 10 + d;
            } else {
                break;
            }
            i++;
        }
        return sign * n;
    }
}
// @lc code=end

