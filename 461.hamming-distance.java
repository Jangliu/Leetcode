/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int n =x^y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
                n = n >> 1;
            } else {
                n = n >> 1;
            }
        }
        return count;
    }
}
// @lc code=end

