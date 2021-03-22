/*
 * @lc app=leetcode id=434 lang=java
 *
 * [434] Number of Segments in a String
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        if(s.length()==0){
            return 0;
        }
        int count = 0;
        boolean flag =true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && flag){
                flag=false;
                count++;
            }
            if(s.charAt(i)==' ')
            {
                flag=true;
            }
        }
        return count;
    }
}
// @lc code=end

