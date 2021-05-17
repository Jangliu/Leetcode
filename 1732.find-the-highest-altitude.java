/*
 * @lc app=leetcode id=1732 lang=java
 *
 * [1732] Find the Highest Altitude
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int max_alt = 0;
        int curr_alt = 0;
        for (int i = 0; i < gain.length; i++) {
            curr_alt += gain[i];
            max_alt = Math.max(curr_alt, max_alt);
        }
        return max_alt;
    }
}
// @lc code=end

