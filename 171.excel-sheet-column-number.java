/*
 * @lc app=leetcode id=171 lang=java
 *
 * [171] Excel Sheet Column Number
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0;
        int n = columnTitle.length();
        for(int i=n-1;i>=0;i--)
        {
            char c =columnTitle.charAt(i);
            count+=((int)c-64)*Math.pow(26, n-1-i);
        }
        return count;
    }
}
// @lc code=end

