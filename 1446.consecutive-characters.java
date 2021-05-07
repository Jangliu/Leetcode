/*
 * @lc app=leetcode id=1446 lang=java
 *
 * [1446] Consecutive Characters
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        int result = 1;
        int j=1;
        char c = s.charAt(0);
        int temp = 1;
        while(j<s.length()){
            if(c==s.charAt(j)){
                temp++;
                j++;
            }
            else{
                c=s.charAt(j);
                result=Math.max(temp, result);
                temp=1;
                j++;
            }
        }
        return Math.max(temp, result);
    }
}
// @lc code=end

