/*
 * @lc app=leetcode id=806 lang=java
 *
 * [806] Number of Lines To Write String
 */

// @lc code=start
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] result = new int[2];
        int sum = 0;
        int nowWide = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sum + widths[s.charAt(i) - 97] > 100) {
                result[0]++;
                sum = widths[s.charAt(i) - 97];
                nowWide = sum;
            } else {
                sum += widths[s.charAt(i) - 97];
                nowWide = sum;
            }
        }
        result[1] = nowWide;
        result[0]++;
        return result;
    }
}
// @lc code=end

