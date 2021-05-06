/*
 * @lc app=leetcode id=1422 lang=java
 *
 * [1422] Maximum Score After Splitting a String
 */

// @lc code=start
class Solution {
    public int maxScore(String s) {
        int[] digits = new int[2];
        int[] ldigits = new int[2];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)) {
                case '0':
                    digits[0]++;
                    break;
                default:
                    digits[1]++;
                    break;
            }
        }
        int result = 0;
        for(int i=0;i<s.length()-1;i++){
            switch(s.charAt(i)){
                case '0':
                    ldigits[0]++;
                    break;
                default:
                    ldigits[1]++;
                    break;
            }
            result = Math.max(result, ldigits[0] + digits[1] - ldigits[1]);
        }
        return result;
    }
}
// @lc code=end

