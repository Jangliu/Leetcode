/*
 * @lc app=leetcode id=1790 lang=java
 *
 * [1790] Check if One String Swap Can Make Strings Equal
 */

// @lc code=start
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int x=-1;
        int y=-1;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(x!=-1&&y!=-1){
                    return false;
                }
                if(x!=-1){
                    y=i;
                }
                else{
                    x=i;
                }
            }
        }
        if(x==-1||y==-1){
            return false;
        }
        return s1.charAt(x)==s2.charAt(y)&&s1.charAt(y)==s2.charAt(x);
    }
}
// @lc code=end

