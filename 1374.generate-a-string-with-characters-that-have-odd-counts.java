/*
 * @lc app=leetcode id=1374 lang=java
 *
 * [1374] Generate a String With Characters That Have Odd Counts
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        int count = (n % 2 == 0) ? n - 1 : n;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append('a');
        }

        if (n % 2 == 0) {
            result.append('b');
        }
        return result.toString();
    }
}
// @lc code=end

