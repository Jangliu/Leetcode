/*
 * @lc app=leetcode id=1556 lang=java
 *
 * [1556] Thousand Separator
 */

// @lc code=start
class Solution {
    public String thousandSeparator(int n) {
        String number = String.valueOf(n);
        char[] c;
        if (number.length() % 3 == 0) {
            c = new char[number.length() + number.length() / 3 - 1];
        } else {
            c = new char[number.length() + number.length() / 3];
        }
        int count = 0;
        int j = c.length - 1;
        for (int i = number.length() - 1; i >= 0; i--) {
            count++;
            c[j] = number.charAt(i);
            j--;
            if (count == 3 && i > 0) {
                count = 0;
                c[j] = '.';
                j--;
            }
        }
        return new String(c);
    }
}
// @lc code=end

