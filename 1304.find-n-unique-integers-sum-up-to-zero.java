/*
 * @lc app=leetcode id=1304 lang=java
 *
 * [1304] Find N Unique Integers Sum up to Zero
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        for(int i=0;i<n/2;i++){
            result[i]=i+1;
            result[n-1-i]=-1-i;
        }
        return result;
    }
}
// @lc code=end

