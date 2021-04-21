/*
 * @lc app=leetcode id=1128 lang=java
 *
 * [1128] Number of Equivalent Domino Pairs
 */

// @lc code=start
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // we need to acceess indexes from 0 to 99. max number of dominoes is 9
        int[] counts = new int[100];
        int res = 0;
        // check every pair of dominoes
        for (int[] d : dominoes) {
            // get upper and down number, make upper always smaller
            int up = d[0] < d[1] ? d[0] : d[1];
            int down = d[0] < d[1] ? d[1] : d[0];
            // increment number of times we've seen exactly this pair
            // if more than once increment result, every next same pair will contribute on 1
            // more than a previous one
            res += counts[up * 10 + down]++;
        }

        return res;
    }
}
// @lc code=end

