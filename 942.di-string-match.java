/*
 * @lc app=leetcode id=942 lang=java
 *
 * [942] DI String Match
 */

// @lc code=start
class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int ip = 0;
        int dp = n;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
            case 'I':
                result[i] = ip;
                ip++;
                break;
            case 'D':
                result[i] = dp;
                dp--;
                break;
            default:
                break;
            }
        }
        result[n] = dp;
        return result;
    }
}
// @lc code=end

