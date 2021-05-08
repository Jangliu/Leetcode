/*
 * @lc app=leetcode id=1486 lang=java
 *
 * [1486] XOR Operation in an Array
 */

// @lc code=start
class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        int temp = start+2;
        for(int i=0;i<n-1;i++){
            result=result^temp;
            temp+=2;
        }
        return result;
    }
}
// @lc code=end

