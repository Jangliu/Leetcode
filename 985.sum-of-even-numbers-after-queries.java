/*
 * @lc app=leetcode id=985 lang=java
 *
 * [985] Sum of Even Numbers After Queries
 */

// @lc code=start
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] sums = new int[A.length];
        int evn_sum = 0;
        for (int a : A)
            if (a % 2 == 0)
                evn_sum += a;

        for (int i = 0; i < A.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0)
                evn_sum -= A[index]; // check if current is even then we are going
            A[index] += val; // add the value //to reduce the even sum value as we are changing it
            if (A[index] % 2 == 0)
                evn_sum += A[index]; // check again,
                                     // if its still even then add it to even sum
            sums[i] = evn_sum;
        }
        return sums;
    }
}
// @lc code=end

