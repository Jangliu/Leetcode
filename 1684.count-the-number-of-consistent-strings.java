import java.util.HashSet;

/*
 * @lc app=leetcode id=1684 lang=java
 *
 * [1684] Count the Number of Consistent Strings
 */

// @lc code=start
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int res=0;
        char[] val = new char[26];
        for(int i=0;i<allowed.length();i++){
            val[allowed.charAt(i)-'a']++;
        }
        for(String s:words){
            int i=0;
            for(;i<s.length();i++){
                if(val[s.charAt(i)-'a']==0){
                    break;
                }
            }
            if(i==s.length()){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

