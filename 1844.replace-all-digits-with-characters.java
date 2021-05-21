/*
 * @lc app=leetcode id=1844 lang=java
 *
 * [1844] Replace All Digits with Characters
 */

// @lc code=start
class Solution {
    public String replaceDigits(String s) {
        StringBuffer res = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                res.append(s.charAt(i));
            }
            else{
                res.append((char)((int)s.charAt(i-1)+ (int)s.charAt(i)- (int)'0'));
            }
        }
        return res.toString();
    }
}
// @lc code=end
