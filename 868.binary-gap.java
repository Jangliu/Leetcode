/*
 * @lc app=leetcode id=868 lang=java
 *
 * [868] Binary Gap
 */

// @lc code=start
class Solution {
    public int binaryGap(int N) {
        String binaryRepresentation = Integer.toBinaryString(N); // O(n) space
        int longestDistance = 0;
        int indexOne = binaryRepresentation.indexOf('1');
        for (int i = 1; i < binaryRepresentation.length(); ++i) { // O(n) time
            if (binaryRepresentation.charAt(i) == '1') {
                longestDistance = Math.max(longestDistance, i - indexOne); // greedy
                indexOne = i; // update the index of the most recently seen '1'
            }
        }

        return longestDistance;
    }
}
// @lc code=end

