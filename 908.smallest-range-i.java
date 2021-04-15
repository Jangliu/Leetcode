/*
 * @lc app=leetcode id=908 lang=java
 *
 * [908] Smallest Range I
 */

// @lc code=start
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++){
            max=Math.max(A[i], max);
            min=Math.min(A[i],min);
        }
        return max-min>=2*K?max-min-2*K:0;
    }
}
// @lc code=end

