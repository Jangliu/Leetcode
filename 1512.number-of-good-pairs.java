import java.util.HashSet;

/*
 * @lc app=leetcode id=1512 lang=java
 *
 * [1512] Number of Good Pairs
 */

// @lc code=start
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        int[] val = new int[101];
        for (int n : nums) {
            val[n]++;
        }
        for (int n : val) {
            if (n >= 2) {
                result += n * (n - 1) / 2;
            }
        }
        return result;
    }
}
// @lc code=end

