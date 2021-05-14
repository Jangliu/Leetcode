/*
 * @lc app=leetcode id=1646 lang=java
 *
 * [1646] Get Maximum in Generated Array
 */

// @lc code=start
class Solution {
    public int getMaximumGenerated(int n) {
        //真就只能硬算
        if (n <= 1) {
            return n == 1 ? 1 : 0;
        }
        int[] val = new int[n + 1];
        val[0] = 0;
        val[1] = 1;
        int res = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                val[i] = val[i / 2];
            } else {
                val[i] = val[i / 2] + val[i / 2 + 1];
            }
            res = Math.max(res, val[i]);
        }
        return res;
    }
}
// @lc code=end

