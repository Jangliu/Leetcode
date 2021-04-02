/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int dup = 1;
        int prevdup = 0;
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                sum += Math.min(prevdup, dup); // calculate sum on bases of previous duplicates and new duplicates
                prevdup = dup; // 因为所要计算在内的子串0和1都必须是一组一组的，所以可以在最长的一组子串统计完后再计算数目。
                dup = 1;
            } else
                dup++; // count duplicates
        }
        sum += Math.min(prevdup, dup);
        return sum;
    }
}
// @lc code=end

