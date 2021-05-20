/*
 * @lc app=leetcode id=1796 lang=java
 *
 * [1796] Second Largest Digit in a String
 */

// @lc code=start
class Solution {
    public int secondHighest(String s) {
        int firstLargest = -1;
        int secondLargest = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                continue;
            }
            int temp = (int) (s.charAt(i) - '0');
            if (temp > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = temp;
                continue;
            }
            if (temp == firstLargest) {
                continue;
            }
            if (temp > secondLargest) {
                secondLargest = temp;
            }
        }
        return secondLargest;
    }
}
// @lc code=end

