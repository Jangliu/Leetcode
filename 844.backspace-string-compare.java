/*
 * @lc app=leetcode id=844 lang=java
 *
 * [844] Backspace String Compare
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        return sb(s).equals(sb(t));
    }

    private String sb(String str) {
        StringBuilder sbr = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            
            if (c != '#') {
                sbr.append(c);
            } else if (sbr.length() != 0) {
                sbr.deleteCharAt(sbr.length() - 1);
            }
        }
        return sbr.toString();
    }
}
// @lc code=end

