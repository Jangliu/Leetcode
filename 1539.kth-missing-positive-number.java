/*
 * @lc app=leetcode id=1539 lang=java
 *
 * [1539] Kth Missing Positive Number
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int check = 1;
        int miss = 0;
        for (int i = 0; i < arr.length; i++) {
            if (check == arr[i]) {
                check++;
            } else {
                while (check < arr[i] && k > 0) {
                    miss = check;
                    check++;
                    k--;
                }
                if (k == 0) {
                    return miss;
                }
                check++;
            }
        }
        miss = arr[arr.length - 1];
        return miss + k;
    }
}
// @lc code=end

