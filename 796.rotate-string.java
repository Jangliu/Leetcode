/*
 * @lc app=leetcode id=796 lang=java
 *
 * [796] Rotate String
 */

// @lc code=start
class Solution {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()){
            return false;
        }
        if(A.equals(B)){
            return true;
        }
        for(int i=0;i<A.length();i++){
            A=A.substring(1, A.length())+A.substring(0, 1);
            if(A.equals(B)){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

