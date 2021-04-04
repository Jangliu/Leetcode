/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
// the top stair is at position n, not the last element at (n - 1)
// If n == 0 or n == 1, the cost is 0 because we can reach the top without cost.
// Define: opt(i) is minimum cost to reach step i; opt(n) is our solution.
// Recurrence: opt(i) = min{ opt(i - 2) + cost[i - 2], opt(i - 1) + cost[i - 1] }
// Initialization: opt(0) = 0, opt(1) = 0 (two starting points)
// Caveat: when i == 1, no need to consider starting from 0 -> 1, since cost[0] + cost[1] must be greater than cost[1] only.
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int f1 = 0, f2 = 0; // init
        for (int i = 2; i <= n; ++i) {
            int temp = Math.min(f1 + cost[i - 2], f2 + cost[i - 1]); // [i - 2] is before
            f1 = f2;
            f2 = temp;
        }
        return f2;
    }
}
// @lc code=end

