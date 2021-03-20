/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        int scount=0;
        int tcount = 0;
        for(int i=0;i<t.length();i++){
            if(i<s.length()){
                scount+=s.charAt(i);
            }
            tcount+=t.charAt(i);
        }
        return (char)(tcount-scount);
    }
}
// @lc code=end

