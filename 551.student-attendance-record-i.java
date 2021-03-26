/*
 * @lc app=leetcode id=551 lang=java
 *
 * [551] Student Attendance Record I
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='A'){
                aCount++;
                if(aCount==2){
                    return false;
                }
                i++;
                continue;
            }
            if(s.charAt(i)=='L'){
                int lCount=1;
                int j=i+1;
                for(;j<s.length();j++){
                    if(s.charAt(j)=='L'){
                        lCount++;
                        if(lCount==3){
                            return false;
                        }
                        continue;
                    }
                    break;
                }
                i=j;
                continue;
            }
            i++;
        }
        return true;
    }
}
// @lc code=end

