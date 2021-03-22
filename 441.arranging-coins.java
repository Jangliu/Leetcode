/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        long number = n;
        return (int) ((Math.sqrt(1 + 8 * number) - 1) / 2);
    }
}
// @lc code=end

