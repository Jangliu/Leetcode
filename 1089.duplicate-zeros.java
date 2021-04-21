/*
 * @lc app=leetcode id=1089 lang=java
 *
 * [1089] Duplicate Zeros
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] result = new int[arr.length];
        int i = 0;
        int j = 0;
        while (i < result.length) {
            if (arr[j] != 0) {
                result[i] = arr[j];
                i++;
                j++;
            } else {
                result[i] = 0;
                if(i+1==result.length){
                    break;
                }
                result[i + 1] = 0;
                i += 2;
                j++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = result[k];
        }
    }
}
// @lc code=end

