/*
 * @lc app=leetcode id=1221 lang=java
 *
 * [1221] Split a String in Balanced Strings
 */

// @lc code=start
class Solution {
    public int balancedStringSplit(String s) {
        int flag=s.charAt(0)=='L'?1:-1;
        int count=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='L'){
                flag++;
            }
            else{
                flag--;
            }
            if(flag==0){
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

