/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int i;
        for(i=length-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                break;
            }
        }
        if(i==-1){
            return 0;
        }
        int num = 0;
        for(;i>=0;i--){
            if(s.charAt(i)!=' '){
                num++;
            }
            else{
                break;
            }
        }
        return num;
    }
}
// @lc code=end

