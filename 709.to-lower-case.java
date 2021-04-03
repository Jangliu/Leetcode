/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 */

// @lc code=start
class Solution {
    public String toLowerCase(String str) {
        String temp = "";
        char ch;
        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            value = ch;
            if (value >= 65 && value <= 90) {
                value = str.charAt(i) + 32;
                ch = (char) value;
            }
            temp += ch;
        }
        return temp;
    }
}
// @lc code=end

