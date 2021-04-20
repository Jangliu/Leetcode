/*
 * @lc app=leetcode id=1021 lang=java
 *
 * [1021] Remove Outermost Parentheses
 */

// @lc code=start
class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (counter != 0)
                    sb.append(c);
                counter++;
            } else {
                counter--;
                if (counter != 0)
                    sb.append(c);
            }
        }

        return sb.toString();
    }
}
// @lc code=end

