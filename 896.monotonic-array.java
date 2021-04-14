/*
 * @lc app=leetcode id=896 lang=java
 *
 * [896] Monotonic Array
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] != A[0]) {
                break;
            }
        }
        if (i == A.length) {
            return true;
        } else {
            boolean flag = A[i] - A[0] > 0 ? true : false;
            int j = i;
            for (; j < A.length; j++) {
                if (A[j] == A[j - 1] || A[j] - A[j - 1] > 0 == flag) {
                    continue;
                } else {
                    break;
                }
            }
            if (j == A.length) {
                return true;
            }
            return false;
        }
    }
}
// @lc code=end

