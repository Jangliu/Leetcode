/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        String result = "";
        int n = columnNumber / 26;
        int rest = columnNumber % 26;
        char c;
        while (n > 0) {
            if (rest == 0) {
                c = (char) (26 + 64);
                columnNumber = (columnNumber - 26) / 26;
            } else {
                c = (char) (rest + 64);
                columnNumber = (columnNumber - rest) / 26;
            }
            result = String.valueOf(c) + result;
            n = columnNumber / 26;
            rest = columnNumber % 26;
        }
        if (rest == 0) {
            return result;
        } else {
            c = (char) (rest + 64);
        }
        result = String.valueOf(c) + result;
        return result;
    }
}
// @lc code=end

