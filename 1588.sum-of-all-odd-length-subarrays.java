/*
 * @lc app=leetcode id=1588 lang=java
 *
 * [1588] Sum of All Odd Length Subarrays
 */

// @lc code=start
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        //画一个图看每一个元素能被选中几次
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += (arr[i] * ((((i + 1) * (arr.length - i)) + 1) / 2));
        return sum;
    }
}
// @lc code=end

