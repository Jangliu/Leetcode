/*
 * @lc app=leetcode id=1534 lang=java
 *
 * [1534] Count Good Triplets
 */

// @lc code=start
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        //似乎遍历是最快的
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a){
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

